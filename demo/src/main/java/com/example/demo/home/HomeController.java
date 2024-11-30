package com.example.demo.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 로그인 후 이동할 홈 페이지
    @GetMapping("/home")
    public String home() {
        return "home"; // home.html로 이동
    }
}
