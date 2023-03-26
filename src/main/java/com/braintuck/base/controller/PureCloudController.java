package com.braintuck.base.controller;

import com.braintuck.base.models.response.AccessTokenResponse;
import com.braintuck.base.service.accesstoken.IPureConnectAccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author GhofranAbdelwahab
 * @Date 26 Mar 2023
 **/
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api")
public class PureCloudController {

    @Autowired
    @Qualifier("PureConnectAccessToken")
    IPureConnectAccessToken service;

    @PostMapping(value = "/login")
    public ResponseEntity<Mono<AccessTokenResponse>> login() {
        return ResponseEntity.status(HttpStatus.OK).body(service.login());
    }

}
