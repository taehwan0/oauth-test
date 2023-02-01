package org.study.oauth.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.oauth.auth.application.AuthService;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    @GetMapping("/kakao/login")
    public String kakaoLogin(String code) {
        return authService.signInByKakao(code);
    }
}
