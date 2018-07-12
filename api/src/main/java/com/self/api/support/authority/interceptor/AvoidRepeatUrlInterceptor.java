package com.self.api.support.authority.interceptor;

import com.alibaba.fastjson.JSON;
import com.self.api.support.authority.annotation.AvoidRepeatUrl;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ShiXin
 * @date 2018/7/12 17:32
 */
public class AvoidRepeatUrlInterceptor implements HandlerInterceptor {

    private static final String DUPLICATION_FLAG = "repeatRequest";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws RuntimeException {
        //如果不是映射到方法直接通过
        if (! (handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.getAnnotation(AvoidRepeatUrl.class) != null) {
            if (isRepeatData(request)) {
                throw new RuntimeException("重复提交");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //如果不是映射到方法直接通过
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (method.getAnnotation(AvoidRepeatUrl.class) != null) {
                System.out.println("=================================移除重复提交FLAG=========================================");
                request.getSession().removeAttribute(DUPLICATION_FLAG);
            }
        }
    }


    /**
     * 验证同一个url数据是否相同提交  ,相同返回true
     *
     * @param httpServletRequest
     * @return
     */
    public boolean isRepeatData(HttpServletRequest httpServletRequest) {

        String params = JSON.toJSONString(httpServletRequest.getParameterMap());
        String url = httpServletRequest.getRequestURI();
        Map<String, String> map = new HashMap();
        map.put(url, params);
        String currentUrl = map.toString();

        Object preUrlParams = httpServletRequest.getSession().getAttribute(DUPLICATION_FLAG);
        if (preUrlParams == null){
            httpServletRequest.getSession().setAttribute(DUPLICATION_FLAG, currentUrl);
            return false;
        } else{
            //如果上次url+数据和本次url+数据相同，则表示重复提交
            if (preUrlParams.toString().equals(currentUrl)) {
                return true;
            } else{//如果上次 url+数据 和本次url加数据不同，则不是重复提交
                httpServletRequest.getSession().setAttribute(DUPLICATION_FLAG, currentUrl);
                return false;
            }

        }
    }

}
