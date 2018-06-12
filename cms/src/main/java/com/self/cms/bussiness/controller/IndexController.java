package com.self.cms.bussiness.controller;


import com.self.cms.bussiness.service.UserService;
import com.self.common.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author chengfengfeng
 * @date 2018/6/5
 */
@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView index() throws InterruptedException {
        ModelAndView mv = new ModelAndView();
        User user = userService.getUser(1);
        mv.setViewName("/index");
        return mv;
    }

    @Async
    private void async() throws InterruptedException {
        for (int i= 0;i<1000;i++){
            System.out.println("async"+i);
        }
        System.out.println("async-end");
    }
}
