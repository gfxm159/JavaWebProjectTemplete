package com.self.cms.system.config;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chengfengfeng
 * @date 2018/6/9
 */
public class MyInterceptor implements HandlerInterceptor {

    private Log _logger = LogFactory.get();

    public static final String IP_IS_UNKNOWN = "unknown";
    public static final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";
    public static final String LOCALHOST_IPV4 = "127.0.0.1";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || IP_IS_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || IP_IS_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || IP_IS_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || IP_IS_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || IP_IS_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (!StringUtils.isEmpty(ip) && ip.equals(LOCALHOST_IPV6)){
            ip = LOCALHOST_IPV4;
        }
        _logger.info("客户端真实请求ip-->>"+ip);
        return true;
    }
}
