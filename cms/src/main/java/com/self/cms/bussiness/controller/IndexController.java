package com.self.cms.bussiness.controller;


import com.self.cms.bussiness.service.ITestService;
import com.self.cms.bussiness.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author chengfengfeng
 * @date 2018/6/5
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private ITestService testService;

    @Async
    void async() throws InterruptedException {
        for (int i= 0;i<1000;i++){
            System.out.println("async"+i);
        }
        System.out.println("async-end");
    }

    /**
     * 该方法提供了一个使用activeMQ生产者的实例
     * 调用该方法，将发送数据到消息队列
     * @param message 消息内容
     * @return
     */
    @RequiresPermissions("send")
    @PostMapping("/sendMessage")
    public @ResponseBody
    String sendMessage(@RequestParam("message") String message){
        testService.sendMessage(message);
        return "success";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "index";
    }
}
