package com.self.cms.bussiness.service;

import org.springframework.web.servlet.ModelAndView;

public interface IUserService {
    ModelAndView login(String username,String password);
    ModelAndView logout();
}
