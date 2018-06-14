package com.self.cms.bussiness.controller.auth;

import com.self.cms.bussiness.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("permission")
@RestController
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    @GetMapping("/permissionList")
    public ModelAndView permissionList(){
        return permissionService.permissionList();
    }
}
