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

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .provider(provider)
                .role(Role.USER)
                .build();
    }

}
