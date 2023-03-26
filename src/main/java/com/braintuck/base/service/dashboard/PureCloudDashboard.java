package com.braintuck.base.service.dashboard;


import com.braintuck.base.models.request.DashboardRequest;
import com.braintuck.base.models.response.DashboardResponse;
import com.braintuck.base.service.accesstoken.IPureCloudAccessToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static com.braintuck.base.models.Constants.*;

@Slf4j
@Component("PureCloudDashboard")
public class PureCloudDashboard implements IPureCloudDashboard {

    @Autowired
    @Qualifier("PureCloudAccessToken")
    IPureCloudAccessToken iPureCloudAccessToken;
    @Autowired
    @Qualifier(PURE_CLOUD_DASHBOARD)
    WebClient.Builder dashboardWebClient;

    @Override
    public Mono<DashboardResponse> buildDashboard(DashboardRequest request) {

        return iPureCloudAccessToken.login()
                .flatMap(response -> {
                            String accessToken = response.getAccess_token();
                            log.info(accessToken);
                            return dashboardWebClient.build()
                                    .post()
                                    .uri(uriBuilder -> uriBuilder.path(PURE_CLOUD_DASHBOARD_PATH_QUERY).build())
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                                    .bodyValue(request)
                                    .retrieve()
                                    .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(Error::new))
                                    .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(Error::new))
                                    .bodyToMono(DashboardResponse.class);
                        }
                );
    }
}
