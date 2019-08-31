package com.xiaomi.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String defaultExceptionHandler(Exception e, HttpServletRequest request, Model m){
        m.addAttribute("error",e.getMessage());
        m.addAttribute("url",request.getRequestURI().toString());
        return "error";
    }
}
