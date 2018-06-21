package com.self.cms.bussiness.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
    ModelAndView login(HttpServletRequest request, String username, String password);
    ModelAndView logout();
}
