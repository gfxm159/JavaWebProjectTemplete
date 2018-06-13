package com.self.cms.bussiness.controller.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("permission")
@RestController
public class PermissionController {
    @GetMapping("/permissionList")
    public ModelAndView permissionList(){
        ModelAndView modelAndView = new ModelAndView("/auth/permissionList");
        return modelAndView;
    }
}
