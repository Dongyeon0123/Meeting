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
                        @RequestParam("phoneNumber") String phoneNumber, // 수정된 이름으로 처리
                        Model model) {

        // 전화번호 끝 4자리를 추출
        String phoneNumberLast4 = phoneNumber.length() >= 4 ? phoneNumber.substring(phoneNumber.length() - 4) : phoneNumber;

        // 입력된 값 확인 로그
        System.out.println("로그인 시도 - 닉네임: " + nickname + ", 전화번호 끝 4자리: " + phoneNumberLast4);

        // 닉네임과 전화번호 끝 4자리로 사용자 조회
        User user = userService.findUserByNicknameAndPhoneNumberEndingWith(nickname, phoneNumberLast4);
        
        if (user != null) {
            // 로그인 성공 처리
            System.out.println("로그인 성공! 사용자: " + user);
            return "/home"; // 대시보드 페이지로 리다이렉트
        } else {
            // 로그인 실패 처리
            System.out.println("로그인 실패! 닉네임과 전화번호를 확인하세요.");
            model.addAttribute("error", "로그인 실패! 닉네임과 전화번호를 확인하세요.");
            return "register/login"; // 로그인 페이지로 다시 이동
        }
    }
}
