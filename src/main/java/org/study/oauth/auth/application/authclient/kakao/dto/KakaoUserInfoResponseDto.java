package org.study.oauth.auth.application.authclient.kakao.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.study.oauth.member.domain.SocialType;
import org.study.oauth.auth.application.authclient.SocialInfo;

@Getter
@NoArgsConstructor
public class KakaoUserInfoResponseDto {

    private Long id;
    private KakaoAccount kakao_account;

    public SocialInfo toSocial() {
        String name = kakao_account.getProfile().getNickname();
        String profileImageUrl = kakao_account.getProfile().getProfile_image_url();

        return new SocialInfo(SocialType.KAKAO, id, name, profileImageUrl);
    }
}
