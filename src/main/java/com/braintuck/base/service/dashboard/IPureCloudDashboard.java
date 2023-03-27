package com.braintuck.base.service.dashboard;


import com.braintuck.base.models.request.DashboardRequest;
import com.braintuck.base.models.response.DashboardResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public interface IPureCloudDashboard {
    Mono<List<DashboardResponse.Metric>> buildDashboard(DashboardRequest request);
}
