package com.self.cms.system.config.auth;

import com.self.common.persistence.entity.AuthPermission;
import com.self.common.persistence.entity.AuthRolePermission;
import com.self.common.persistence.entity.AuthUser;
import com.self.common.persistence.entity.AuthUserRole;
import com.self.common.persistence.mapper.generate.AuthPermissionMapper;
import com.self.common.persistence.mapper.generate.AuthRolePermissionMapper;
import com.self.common.persistence.mapper.generate.AuthUserMapper;
import com.self.common.persistence.mapper.generate.AuthUserRoleMapper;
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
        //放入shiro.调用CredentialsMatcher检验密码
        return new SimpleAuthenticationInfo(authUser, password,this.getClass().getName());
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        AuthUser authUser = (AuthUser)principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        AuthUserRole authUserRoleSelect = new AuthUserRole();
        authUserRoleSelect.setUserId(authUser.getId());
        List<AuthUserRole> authUserRoleList = authUserRoleMapper.select(authUserRoleSelect);
        List<String> permissionList = new ArrayList<>();
        for (AuthUserRole authUserRole:authUserRoleList){
            AuthRolePermission authRolePermissionSelect = new AuthRolePermission();
            authRolePermissionSelect.setRoleId(authUserRole.getRoleId());
            List<AuthRolePermission> authRolePermissionList = authRolePermissionMapper.select(authRolePermissionSelect);
            for(AuthRolePermission authRolePermission:authRolePermissionList){
                AuthPermission authPermission = authPermissionMapper.
                        selectByPrimaryKey(authRolePermission.getPermissionId());
                permissionList.add(authPermission.getUrl());
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        info.addStringPermissions(permissionList);//将权限放入shiro中.
        return info;
    }


}
