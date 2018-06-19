package com.self.cms.bussiness.controller;


import com.alibaba.fastjson.JSON;
import com.self.cms.bussiness.service.ITestService;
import com.self.cms.bussiness.service.RedisService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author chengfengfeng
 * @date 2018/6/5
 */
@Controller
public class IndexController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private ITestService testService;


    @ResponseBody
    @RequestMapping("/redis")
    public String redis(){
        return JSON.toJSONString(redisService.getForRedis("cheng"));
    }
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
    @PostMapping("/sendMessage")
    public @ResponseBody
    String sendMessage(@RequestParam("message") String message){
        testService.sendMessage(message);
        return "success";
    }

}
