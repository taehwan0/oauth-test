package org.study.oauth.auth.application.authclient.kakao.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenResponseDto {

    private String token_type;
    private String access_token;
    private Integer expires_in;
    private String refresh_token;
    private Integer refresh_token_expires_in;

    @Override
    public String toString() {
        return "TokenResponseDto{" +
            "token_type='" + token_type + '\'' +
            ", access_token='" + access_token + '\'' +
            ", expires_in=" + expires_in +
            ", refresh_token='" + refresh_token + '\'' +
            ", refresh_token_expires_in=" + refresh_token_expires_in +
            '}';
    }
}
