package com.github.edsandrof.infnetjavaweb.application.controller;

import com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultHandler(HttpServletRequest request, Exception e) {
        System.out.println("Error: " + e.getMessage());
        return new ModelAndView(Constant.Page.ERROR);
    }
}
