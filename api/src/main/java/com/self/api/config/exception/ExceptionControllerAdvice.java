package com.self.api.config.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@ControllerAdvice(annotations = RestController.class, basePackages = "com.self.api")
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public @ResponseBody
    Object handleAppException(HttpServletRequest request, HttpServletResponse response, RuntimeException exception) {
        return null;
    }
}
