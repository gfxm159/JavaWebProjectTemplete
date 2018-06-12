package com.self.cms.system.aop;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 拦截所有请求 打印日志
 *
 * @author chengfengfeng
 * @date 2018/6/5
 */
@Component
@Aspect
@Order(1)
public class LogAop {

    public Log _logger = LogFactory.get();

    @Pointcut("execution(public * com.self.cms.bussiness.controller..*.*(..))")
    public void cut() {
    }

    @Before("cut()")
    public void before() {
        System.out.println("@Before");
    }

    @After("cut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("@After");
        Object[] arr = joinPoint.getArgs();
        List<Object> list = Lists.newArrayList();
        for (Object obj : arr) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof HttpServletRequest || obj instanceof HttpServletResponse) {
                continue;
            }
            list.add(obj.toString());
        }
        String args = Joiner.on(",").join(list);
        String key = String.format("%s.%s",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName());

        _logger.info(String.format("method=[%s],args=[%s]", key, args));


    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("@Around前");
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
        System.out.println("@Around后");
        return result;
    }
}
