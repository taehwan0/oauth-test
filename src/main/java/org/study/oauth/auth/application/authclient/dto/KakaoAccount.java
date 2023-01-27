package org.study.oauth.auth.application.authclient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoAccount {

    private Boolean profile_needs_agreement;
    private Profile profile;

    @Getter
    @NoArgsConstructor
    static class Profile {
        private String nickname;
        private String thumbnail_image_url;
        private String profile_image_url;
        private Boolean is_default_image;
    }
}
