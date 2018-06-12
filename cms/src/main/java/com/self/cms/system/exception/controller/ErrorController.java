package com.self.cms.system.exception.controller;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot默认出现异常会抛到/error路径
 * 在此方法内包含了返回view或者返回json
 * @author chengfengfeng
 * @date 2018/6/7
 */
@Controller
public class ErrorController extends AbstractErrorController {
    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    private static final Log _logger = LogFactory.get();
    public static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> error = Collections.unmodifiableMap
                (getErrorAttributes(request, false));
        //状态码
        int status = (int) error.get("status");
        //错误信息
        String message = (String) error.get("message");
        //获取异常
        Throwable throwable = getCause(request);
        //获取返回信息
        String errorMsg = getErrorMsg(throwable);
        //打印错误日志
        _logger.error(status + "," + message, throwable);
        /*
         * 返回前端数据
         */
        if (!isJsonRequest(request)) {
            ModelAndView mv = new ModelAndView("/error");
            mv.addObject("errorMsg", errorMsg);
            return mv;
        } else {
            Map map = new HashMap(3);
            map.put("code", -1);
            map.put("msg", errorMsg);
            writeJson(map, response);
            return null;
        }


    }

    /**
     * 获取真正的异常
     *
     * @param request
     * @return
     */
    private Throwable getCause(HttpServletRequest request) {
        Throwable throwable =
                (Throwable) request.getAttribute("javax.servlet.error.exception");
        if (throwable != null) {
            /*
             *  springMVC 有可能将异常封装成ServletException 需要getCause获取真正的异常
             *  为什么写while 因为会包装太多层
             */
            while (throwable instanceof ServletException && throwable.getCause() != null) {
                throwable = throwable.getCause();
            }
        }
        return throwable;
    }

    /**
     * 根据异常获取 友好错误信息  重点是处理错误
     * @param ex
     * @return
     */
    private String getErrorMsg(Throwable ex) {
        return "服务器内部错误，请联系管理员";
    }

    /**
     * 判断是否是json数据返回
     *
     * @return
     */
    private boolean isJsonRequest(HttpServletRequest request) {
        String uri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (request.getHeader("Accept").contains("application/json")) {

        }
        return false;
    }

    /**
     * 写json数据回客户端
     *
     * @param map
     * @param response
     */
    private void writeJson(Map map, HttpServletResponse response) {
        ServletOutputStream responseOutputStream = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            responseOutputStream = response.getOutputStream();
            response.setStatus(HttpServletResponse.SC_OK);
            output.writeTo(responseOutputStream);
            output.flush();
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (responseOutputStream != null) {
                try {
                    responseOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
