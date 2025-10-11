package com.house58.terra.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.security.oauth2.client.resourceserver.jwt")
@Data
public class JwtConfig {

    private String issuerUri;

    public Object getIssuerUri() {
        return null;
    }
}
