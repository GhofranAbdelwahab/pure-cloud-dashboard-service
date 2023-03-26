package com.braintuck.base.service.accesstoken;


import com.braintuck.base.models.response.AccessTokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static com.braintuck.base.models.Constants.PURE_CLOUD_LOGIN_BEAN;
import static com.braintuck.base.models.Constants.PURE_CLOUD_LOGIN_PATH_AUTH;

@Slf4j
@Component("PureConnectAccessToken")
public class PureConnectAccessToken implements IPureConnectAccessToken {

    @Autowired
    @Qualifier(PURE_CLOUD_LOGIN_BEAN)
    WebClient.Builder loginWebClient;

    @Override
    public Mono<AccessTokenResponse> login() {
        return loginWebClient.build()
                .post()
                .uri(uriBuilder -> uriBuilder.path(PURE_CLOUD_LOGIN_PATH_AUTH).build())
                .contentType (MediaType.APPLICATION_FORM_URLENCODED)
                .header(HttpHeaders.AUTHORIZATION,"Basic MjlhYTEzYzctMTY5My00N2RjLTg2NzItZmI1MDI5OTA5NzFjOmJDb1lPczFxZU9jWGpEZndRTTZYVkEta2ZZSWwwd1lpTHlMVnJiajdJQWM=")
                .body(BodyInserters.fromFormData("grant_type","client_credentials"))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(Error::new))
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(Error::new))
                .bodyToMono(AccessTokenResponse.class);
    }


}
