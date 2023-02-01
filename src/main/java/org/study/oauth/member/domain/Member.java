package org.study.oauth.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.study.oauth.auth.application.authclient.SocialInfo;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialType socialType;

    @Column(nullable = false)
    private Long socialId;

    private Member(String name, String profileImageUrl, SocialType socialType, Long socialId) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.socialType = socialType;
        this.socialId = socialId;
    }

    public static Member of(SocialInfo socialInfo) {
        return new Member(
            socialInfo.getName(),
            socialInfo.getProfileImageUrl(),
            socialInfo.getSocialType(),
            socialInfo.getSocialId());
    }
}
