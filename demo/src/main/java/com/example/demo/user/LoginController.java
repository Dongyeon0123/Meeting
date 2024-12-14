package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // 로그인 폼 표시
    @GetMapping("/register/login")
    public String showLoginForm() {
        return "register/login";
    }

    // 로그인 처리
    @PostMapping("/register/login")
    public String login(@RequestParam("nickname") String nickname,
                        @RequestParam("phoneNumber") String phoneNumber, Model model) {

        // 입력된 nickname과 phoneNumber 값 로그로 출력
        System.out.println("입력된 닉네임: " + nickname);
        System.out.println("입력된 전화번호: " + phoneNumber);

        // 사용자 조회
        User user = userService.findUserByNicknameAndPhoneNumber(nickname, phoneNumber);

        if (user != null) {
            // 로그인 성공 시
            System.out.println("로그인 성공! 사용자: " + user);
            return "home";  // 성공 시 홈 페이지로 리다이렉트
        } else {
            // 로그인 실패 시
            System.out.println("로그인 실패! 닉네임과 전화번호를 확인하세요.");
            model.addAttribute("error", "로그인 실패! 닉네임과 전화번호를 확인하세요.");
            return "register/login";  // 실패 시 로그인 페이지로 다시 돌아감
        }
    }
}
