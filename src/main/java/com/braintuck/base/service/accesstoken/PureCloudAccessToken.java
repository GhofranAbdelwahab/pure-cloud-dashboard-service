package com.braintuck.base.service.accesstoken;


import com.braintuck.base.models.response.AccessTokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static com.braintuck.base.models.Constants.PURE_CLOUD_LOGIN_BEAN;
import static com.braintuck.base.models.Constants.PURE_CLOUD_LOGIN_PATH_AUTH;

@Slf4j
@Component("PureCloudAccessToken")
public class PureCloudAccessToken implements IPureCloudAccessToken {

    @Autowired
    @Qualifier(PURE_CLOUD_LOGIN_BEAN)
    WebClient.Builder loginWebClient;

    private static final String CONTEXT_REQUEST_ID_KEY = "PURE_CLOUD_REQUEST_ID";
    private static final String GRANT_TYPE = "grant_type";
    private static final String CLIENT_CREDENTIALS = "client_credentials";

    @Value("${application.client.id}")
    private String username;

    @Value("${application.client.secret}")
    private String password;

    @Override
    public Mono<AccessTokenResponse> login() {
        return loginWebClient.build()
                .post()
                .uri(uriBuilder -> uriBuilder.path(PURE_CLOUD_LOGIN_PATH_AUTH).build())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .headers(headers -> {
                    headers.setBasicAuth(username, password);
                })
                .body(BodyInserters.fromFormData(GRANT_TYPE, CLIENT_CREDENTIALS))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(Error::new))
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(Error::new))
                .bodyToMono(AccessTokenResponse.class);
    }
}
