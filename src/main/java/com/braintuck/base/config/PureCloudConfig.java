package com.braintuck.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import static com.braintuck.base.models.Constants.*;

@Configuration
public class PureCloudConfig {
    @Bean(PURE_CLOUD_LOGIN_BEAN)
    public WebClient.Builder webClientLoginPureCloud() {
        return WebClient.builder()
                           .baseUrl(PURE_CLOUD_LOGIN_BASE_URL);
    }

    @Bean(PURE_CLOUD_DASHBOARD)
    public WebClient.Builder webClientDashboardPureCloud() {
        return WebClient.builder()
                .baseUrl(PURE_CLOUD_DASHBOARD_BASE_URL);
    }
}
