package com.example.demo.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 404 에러 처리
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404Error(NoHandlerFoundException ex, Model model) {
        model.addAttribute("message", "페이지를 찾을 수 없습니다.");
        return "error"; // error.html로 이동
    }

    // 일반적인 예외 처리
    @ExceptionHandler(Exception.class)
    public String handleGeneralError(Exception ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error"; // error.html로 이동
    }
}
