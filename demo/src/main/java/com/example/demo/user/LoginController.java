package com.example.demo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // 로그인 페이지를 반환하는 메소드
    @GetMapping("/register/login")
    public String showLoginForm() {
        return "register/login"; // login.html 파일을 반환
    }
}
