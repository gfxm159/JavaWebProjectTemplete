package com.self.cms.system.config.auth;

import com.self.cms.bussiness.constants.Constants;
import com.self.common.persistence.entity.*;
import com.self.common.persistence.mapper.generate.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private AuthUserMapper authUserMapper;
    @Autowired
    private AuthUserRoleMapper authUserRoleMapper;
    @Autowired
    private AuthRolePermissionMapper authRolePermissionMapper;
    @Autowired
    private AuthPermissionMapper authPermissionMapper;
    @Autowired
    private AuthUserPermissionMapper authUserPermissionMapper;
    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        AuthUser authUser = authUserMapper.selectByLoginName(username);
        String password = null;
        if(authUser!=null){
            password = authUser.getPassword();
        }
        UserDetails userDetails = new UserDetails(authUser.getLoginName());
        //放入shiro.调用CredentialsMatcher检验密码
        return new SimpleAuthenticationInfo(userDetails, password,this.getClass().getName());
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        AuthUser authUser = (AuthUser)principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        AuthUserRole authUserRoleSelect = new AuthUserRole();
        authUserRoleSelect.setUserId(authUser.getId());
        List<AuthUserRole> authUserRoleList = authUserRoleMapper.select(authUserRoleSelect);
        List<String> permissionList = new ArrayList<>();
        //TODO 待优化，查询次数太多，前期不稳定尽量少写sql,
        for (AuthUserRole authUserRole:authUserRoleList){
            AuthRolePermission authRolePermissionSelect = new AuthRolePermission();
            authRolePermissionSelect.setRoleId(authUserRole.getRoleId());
            List<AuthRolePermission> authRolePermissionList = authRolePermissionMapper.select(authRolePermissionSelect);
            for(AuthRolePermission authRolePermission:authRolePermissionList){
                AuthPermission authPermissionSelect = new AuthPermission();
                authPermissionSelect.setId(authRolePermission.getPermissionId());
                authPermissionSelect.setFlag(Constants.权限);
                AuthPermission authPermission = authPermissionMapper.
                        selectOne(authPermissionSelect);
                if(authPermission!=null) {
                    permissionList.add(authPermission.getPermission());
                }
            }
        }
        AuthUserPermission authUserPermissionSelect = new AuthUserPermission();
        authUserPermissionSelect.setUserId(authUser.getId());
        List<AuthUserPermission> authUserPermissionList = authUserPermissionMapper.select(authUserPermissionSelect);
        for(AuthUserPermission authUserPermission:authUserPermissionList){
            AuthPermission authPermissionSelect = new AuthPermission();
            authPermissionSelect.setId(authUserPermission.getPermissionId());
            authPermissionSelect.setFlag(Constants.权限);
            AuthPermission authPermission = authPermissionMapper.
                    selectOne(authPermissionSelect);
            if(authPermission!=null) {
                permissionList.add(authPermission.getPermission());
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        info.addStringPermissions(permissionList);//将权限放入shiro中.
        return info;
    }


}
