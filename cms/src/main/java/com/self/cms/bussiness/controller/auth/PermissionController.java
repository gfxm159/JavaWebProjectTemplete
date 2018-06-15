package com.self.cms.bussiness.controller.auth;

import com.self.cms.bussiness.service.IPermissionService;
import com.self.cms.system.config.auth.UserDetails;
import com.self.common.persistence.entity.AuthPermission;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("permission")
@RestController
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    @GetMapping("/permissionList")
    public ModelAndView permissionList(){
        return permissionService.permissionList();
    }
    @PostMapping("getPermissionListById")
    public List<AuthPermission> getPermissionListById(Integer id){
        return permissionService.getPermissionListById(id);
    }
}
