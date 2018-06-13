package com.self.cms.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author chengfengfeng
 * @date 2018/6/6
 */
@Component
public class MyTimer {

    @Scheduled(cron = "* 0/1 * * * *")
    public void showLog(){
//        System.out.println("====*running*====");
//        System.out.println("***********当前时间："+System.currentTimeMillis());
    }
}
