package org.study.oauth.auth.application.authclient.kakao.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoAccount {

    private Boolean profile_needs_agreement;
    private Profile profile;

    @Override
    public String toString() {
        return "KakaoAccount{" +
            "profile_needs_agreement=" + profile_needs_agreement +
            ", profile=" + profile +
            '}';
    }
}
