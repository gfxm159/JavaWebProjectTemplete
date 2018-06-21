package com.self.cms.bussiness.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.self.cms.bussiness.beans.AuthBean;
import com.self.cms.bussiness.beans.PageIO;
import com.self.cms.bussiness.beans.PageVO;
import com.self.cms.bussiness.service.IUserService;
import com.self.cms.system.config.auth.UserDetails;
import com.self.common.persistence.entity.AuthPermission;
import com.self.common.persistence.entity.AuthUser;
import com.self.common.persistence.entity.AuthUserRole;
import com.self.common.persistence.mapper.generate.AuthPermissionMapper;
import com.self.common.persistence.mapper.generate.AuthUserMapper;
import com.self.common.persistence.mapper.generate.AuthUserRoleMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private AuthUserMapper authUserMapper;
    @Autowired
    private AuthUserRoleMapper authUserRoleMapper;
    @Autowired
    private AuthPermissionMapper authPermissionMapper;

    @Override
    public ModelAndView login(HttpServletRequest request,String username, String password) {
        ModelAndView modelAndView = new ModelAndView();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            //填充登陆数
            UserDetails userDetails = (UserDetails)SecurityUtils.getSubject().getPrincipal();
            userDetails.setLoginName(username);
            //session填充权限数据,并将权限数据填充到session，后续可以考虑填充到redis
            List<AuthBean> authBeanList = getauthBeanList(userDetails);
            request.getSession().setAttribute("authBeanList",authBeanList);
            modelAndView.setViewName("index");
        } catch(Exception e) {
            //返回登录页面
            e.printStackTrace();
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
    //获取用户具有的权限
    private List<AuthBean> getauthBeanList(UserDetails userDetails){
        List<AuthBean> authBeanList = new ArrayList<>();
        //获取用户具有的角色
        AuthUserRole authUserRoleSelect = new AuthUserRole();
        authUserRoleSelect.setUserId(userDetails.getUserId());
        List<AuthUserRole> authUserRoleList = authUserRoleMapper.select(authUserRoleSelect);
        if(authUserRoleList==null){
            authUserRoleList.add(new AuthUserRole());
        }
        List<AuthPermission> authPermissionList = authPermissionMapper.selectByRoleIds(authUserRoleList);

        //遍历第一遍，将一级菜单填充到List
        for (AuthPermission authPermission:authPermissionList){
            if(authPermission.getpId()==0){
                AuthBean authBean = new AuthBean(authPermission.getId(),authPermission.getIcon(),
                        authPermission.getName(),
                        authPermission.getUrl(),false,null);
                authBeanList.add(authBean);
            }
        }
        //遍历二级菜单
        for (AuthPermission authPermission:authPermissionList){
            if(authPermission.getpId()!=0){
                for (AuthBean authBean:authBeanList)
                    if(authBean.getId().equals(authPermission.getpId())){
                        AuthBean menu = new AuthBean(authPermission.getId(),
                                authPermission.getIcon(),
                                authPermission.getName(),
                                authPermission.getUrl(),null,null);
                        if(authBean.getHasMenu()==false){
                            List<AuthBean> menuList = new ArrayList<>();
                            menuList.add(menu);
                            authBean.setHasMenu(true);
                            authBean.setMenuList(menuList);
                        }else {
                            authBean.getMenuList().add(menu);
                        }
                    }
            }
        }
        return authBeanList;
    }

    @Override
    public ModelAndView logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ModelAndView("login");
    }

    @Override
    public ModelAndView toUserList() {
        return new ModelAndView("auth/userList");
    }

    @Override
    public PageVO getAuthUserList(PageIO pageIO) {
        Page page = PageHelper.startPage(pageIO.getPage(), pageIO.getRows());
        authUserMapper.selectUserAndRole();
        return new PageVO(page);
    }
}
