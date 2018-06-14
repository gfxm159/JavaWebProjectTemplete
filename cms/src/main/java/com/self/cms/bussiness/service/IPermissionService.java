package com.self.cms.bussiness.service;

import com.self.common.persistence.entity.AuthPermission;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface IPermissionService {
    ModelAndView permissionList();
    List<AuthPermission> getPermissionListById(Integer id);
}
