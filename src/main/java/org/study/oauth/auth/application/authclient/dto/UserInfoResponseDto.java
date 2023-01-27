package org.study.oauth.auth.application.authclient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoResponseDto {

    private Long id;
    private KakaoAccount kakaoAccount;
}
