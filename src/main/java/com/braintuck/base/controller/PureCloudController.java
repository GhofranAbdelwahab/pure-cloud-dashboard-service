package com.braintuck.base.controller;

import com.braintuck.base.models.request.DashboardRequest;
import com.braintuck.base.models.response.DashboardResponse;
import com.braintuck.base.service.dashboard.IPureCloudDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author GhofranAbdelwahab
 * @Date 26 Mar 2023
 **/
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api")
public class PureCloudController {

    @Autowired
    @Qualifier("PureCloudDashboard")
    IPureCloudDashboard service;

    @PostMapping(value = "/dashboard")
    public ResponseEntity<Mono<List<DashboardResponse.Metric>>> dashboard() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buildDashboard(new DashboardRequest()));
    }
}
