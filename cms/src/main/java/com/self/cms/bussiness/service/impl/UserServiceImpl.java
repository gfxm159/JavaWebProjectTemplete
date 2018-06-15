package com.self.cms.bussiness.service.impl;

import com.self.cms.bussiness.service.IUserService;
import com.self.cms.system.config.auth.UserDetails;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public ModelAndView login(String username, String password) {
        ModelAndView modelAndView = new ModelAndView();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            //填充登陆数据
            UserDetails userDetails = (UserDetails)SecurityUtils.getSubject().getPrincipal();
            userDetails.setLoginName(username);
            modelAndView.setViewName("index");
        } catch(Exception e) {
            //返回登录页面
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @Override
    public ModelAndView logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ModelAndView("login");
    }
}
