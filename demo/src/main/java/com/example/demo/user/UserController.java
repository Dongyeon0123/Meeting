package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")  // /register 경로로 묶기
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입 폼을 보여주는 GET 요청
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());  // 새로운 User 객체를 폼에 전달
        return "register/signup";  // signup.html로 이동
    }

    // 회원가입 데이터를 처리하는 POST 요청
    @PostMapping("/signup")
    public String signup(User user) {
        // 회원가입 처리 (DB에 저장)
        User savedUser = userService.saveUser(user);  // UserService에서 유저 저장
        System.out.println("Saved user: " + savedUser);  // 콘솔에 저장된 사용자 출력
        return "redirect:/register/login";  // 회원가입 완료 후 로그인 페이지로 리디렉션
    }
}
