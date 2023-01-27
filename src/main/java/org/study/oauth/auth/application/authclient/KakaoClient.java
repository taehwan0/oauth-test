package org.study.oauth.auth.application.authclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.study.oauth.auth.application.authclient.dto.TokenResponseDto;
import reactor.core.publisher.Mono;

@Component
public class KakaoClient {

    private static final String REQUEST_TOKEN_URL = "https://kauth.kakao.com/oauth/token";
    private static final String REQUEST_USER_INFO_URL = "https://kapi.kakao.com/v2/user/me";

    private final String appKey;
    private final String redirectUri;
    private final String clientSecret;
    private final WebClient tokenClient;
    private final WebClient userInfoClient;

    public KakaoClient(
        @Value("${oauth.kakao.appKey}") String appKey,
        @Value("${oauth.kakao.redirectUrl}") String redirectUri,
        @Value("${oauth.kakao.clientSecret}") String clientSecret,
        WebClient webClient) {
        this.appKey = appKey;
        this.redirectUri = redirectUri;
        this.clientSecret = clientSecret;
        this.tokenClient = toWebclient(webClient, REQUEST_TOKEN_URL);
        this.userInfoClient = toWebclient(webClient, REQUEST_USER_INFO_URL);
    }

    private WebClient toWebclient(WebClient webClient, String baseUrl) {
        return webClient.mutate()
            .baseUrl(baseUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            .build();
    }

    public String requestAccessToken(String code) {
        System.out.println(code);

        TokenResponseDto tokenResponseDto = tokenClient.post()
            .body(BodyInserters.fromFormData(createRequestTokenBody(code)))
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new RuntimeException("요청 실패~")))
            .bodyToMono(TokenResponseDto.class)
            .block();

        System.out.println(tokenResponseDto);

        return tokenResponseDto.getAccess_token();
    }

    private MultiValueMap<String, String> createRequestTokenBody(String code) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "authorization_code");
        requestBody.add("client_id", appKey);
        requestBody.add("redirect_uri", redirectUri);
        requestBody.add("client_secret", clientSecret);
        requestBody.add("code", code);

        return requestBody;
    }
}
