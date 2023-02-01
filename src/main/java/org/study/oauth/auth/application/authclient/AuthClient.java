package org.study.oauth.auth.application.authclient;

public interface AuthClient {

    String getAccessToken(String code);

    SocialInfo getSocialInfo(String accessToken);

}
