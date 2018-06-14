package com.self.cms.bussiness.service.impl;

import com.self.cms.bussiness.constants.Constants;
import com.self.cms.bussiness.service.IPermissionService;
import com.self.common.persistence.entity.AuthPermission;
import com.self.common.persistence.mapper.generate.AuthPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private AuthPermissionMapper authPermissionMapper;
    @Override
    public ModelAndView permissionList() {
        ModelAndView modelAndView = new ModelAndView("/auth/permissionList");
        AuthPermission authPermissionSelect = new AuthPermission();
        authPermissionSelect.setFlag(Constants.菜单);
        List<AuthPermission> menu =  authPermissionMapper.select(authPermissionSelect);
        modelAndView.addObject("menu",menu);
        return modelAndView;
    }

    @Override
    public List<AuthPermission> getPermissionListById(Integer id) {
        AuthPermission authPermissionSelect = new AuthPermission();
        authPermissionSelect.setFlag(Constants.权限);
        authPermissionSelect.setpId(id);
        List<AuthPermission> authPermissionList = authPermissionMapper.select(authPermissionSelect);
        return authPermissionList;
    }
}
