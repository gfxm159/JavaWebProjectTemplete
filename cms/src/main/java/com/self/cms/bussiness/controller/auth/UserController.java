package com.self.cms.bussiness.controller.auth;

import com.self.cms.bussiness.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public String index() throws InterruptedException {
        return "index";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @PostMapping("/login")
    public ModelAndView  login(HttpServletRequest request, String username, String password) throws Exception{
        return userService.login(request,username,password);
    }
    @GetMapping("/logout")
    public ModelAndView logout(){
        return userService.logout();
    }
}
