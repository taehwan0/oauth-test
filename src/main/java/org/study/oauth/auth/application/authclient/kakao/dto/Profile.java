package org.study.oauth.auth.application.authclient.kakao.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Profile {

    private String nickname;
    private String thumbnail_image_url;
    private String profile_image_url;
    private Boolean is_default_image;

    @Override
    public String toString() {
        return "Profile{" +
            "nickname='" + nickname + '\'' +
            ", thumbnail_image_url='" + thumbnail_image_url + '\'' +
            ", profile_image_url='" + profile_image_url + '\'' +
            ", is_default_image=" + is_default_image +
            '}';
    }
}
