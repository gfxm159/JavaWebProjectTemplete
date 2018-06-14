package com.self.cms.bussiness.service.impl;

import com.self.cms.bussiness.service.IPermissionService;
import org.springframework.web.servlet.ModelAndView;

public class PermissionServiceImpl implements IPermissionService {
    @Override
    public ModelAndView permissionList() {
        ModelAndView modelAndView = new ModelAndView("/auth/permissionList");
        return modelAndView;
    }
}
