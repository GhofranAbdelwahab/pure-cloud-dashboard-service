package com.braintuck.base.service.dashboard;


import com.braintuck.base.models.request.DashboardRequest;
import com.braintuck.base.models.response.DashboardResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface IPureCloudDashboard {
    Mono<DashboardResponse> buildDashboard(DashboardRequest request);
}
