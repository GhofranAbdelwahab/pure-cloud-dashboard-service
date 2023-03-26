package com.braintuck.base.service.accesstoken;


import com.braintuck.base.models.response.AccessTokenResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface IPureCloudAccessToken {
    Mono<AccessTokenResponse> login();
}
