package com.self.cms.bussiness.service;

import com.self.cms.bussiness.beans.PageIO;
import com.self.cms.bussiness.beans.PageVO;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
    ModelAndView login(HttpServletRequest request, String username, String password);
    ModelAndView logout();
    ModelAndView toUserList();
    PageVO getAuthUserList(PageIO pageIO);
}
