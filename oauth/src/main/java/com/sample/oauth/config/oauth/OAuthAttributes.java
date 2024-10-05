package com.sample.oauth.config.oauth;

import com.sample.oauth.domain.User;
import com.sample.oauth.domain.enums.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String provider;

    public static OAuthAttributes oauth(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        // naver
        if ("naver".equals(registrationId)) {
            return oauthNaver("id", attributes);
        // kakao
        } else if ("kakao".equals(registrationId)) {
            return oauthKakao("id", attributes);
        }

        // google
        return oauthGoogle(userNameAttributeName, attributes);
    }

    // google
    private static OAuthAttributes oauthGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    // naver
    private static OAuthAttributes oauthNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .provider("Naver")
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    // kakao
    private static OAuthAttributes oauthKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> account = (Map<String, Object>) response.get("profile");

        return OAuthAttributes.builder()
                .name((String) account.get("nickname"))
                .email((String) response.get("email"))
                .provider("Kakao")
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .provider(provider)
                .role(Role.USER)
                .build();
    }

}
