package com.self.cms.system.log;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 拦截所有请求 打印日志
 * @author chengfengfeng
 * @date 2018/6/5
 */
@Component
@Aspect
@Order(1)
public class LogAop {

    public Log _logger = LogFactory.get();

    @Pointcut("execution(public * com.cheng.bussiness.controller..*.*(..))")
    public void cut(){}

    @Around("cut()")
    public Object monitorElapsedTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        // Log the elapsed time
        double elapsedTime = stopWatch.getTotalTimeSeconds();
        Signature signature = proceedingJoinPoint.getSignature();
        String infoString = signature.toShortString() + "  -> " + elapsedTime + " s";
        if (elapsedTime > 1) {
            _logger.warn("[耗时过长!!!]" + infoString);
        } else {
            _logger.info(infoString);
        }
        return result;
    }
}
