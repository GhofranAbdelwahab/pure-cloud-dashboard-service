package com.braintuck.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import static com.braintuck.base.models.Constants.PURE_CLOUD_LOGIN_BASE_URL;
import static com.braintuck.base.models.Constants.PURE_CLOUD_LOGIN_BEAN;

@Configuration
public class PureCloudConfig {
    @Bean(PURE_CLOUD_LOGIN_BEAN)
    public WebClient.Builder webClientLoginPureCloud() {
        return WebClient.builder()
                           .baseUrl(PURE_CLOUD_LOGIN_BASE_URL);
    }
}
