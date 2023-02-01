package org.study.oauth.auth.application.authclient;

import lombok.Getter;
import org.study.oauth.member.domain.SocialType;

@Getter
public class SocialInfo {

    private final SocialType socialType;
    private final Long socialId;
    private final String name;
    private final String profileImageUrl;

    public SocialInfo(SocialType socialType, Long socialId, String name, String profileImageUrl) {
        this.socialType = socialType;
        this.socialId = socialId;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }
}
