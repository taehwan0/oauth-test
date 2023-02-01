package org.study.oauth.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.study.oauth.auth.application.authclient.kakao.KakaoClient;
import org.study.oauth.auth.application.authclient.SocialInfo;
import org.study.oauth.member.application.MemberService;
import org.study.oauth.member.domain.Member;

@Transactional
@RequiredArgsConstructor
@Service
public class AuthService {

    private final MemberService memberService;

    private final KakaoClient kakaoClient;

    public String signInByKakao(String code) {

        SocialInfo socialInfo = getSocialInfoByKakao(code);

        Member member = getUserWithSignUp(socialInfo);

        return createToken(member);
    }

    private Member getUserWithSignUp(SocialInfo socialInfo) {
        return memberService.getMember(socialInfo.getSocialType(), socialInfo.getSocialId())
            .orElseGet(() -> memberService.createMember(socialInfo));
    }

    private SocialInfo getSocialInfoByKakao(String code) {
        String accessToken = kakaoClient.getAccessToken(code);
        return kakaoClient.getSocialInfo(accessToken);
    }

    private String createToken(Member member) {
        // Member 의 access, refresh token 발급!
        return "jwt" + member.getName();
    }
}
