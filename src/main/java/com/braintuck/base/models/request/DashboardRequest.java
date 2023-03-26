package com.braintuck.base.models.request;

import com.braintuck.base.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;


@Data
@Valid
@AllArgsConstructor
@NoArgsConstructor
public class DashboardRequest {
    private String interval = DateUtils.buildInverterOfCurrentDay();
    private Filter filter;
    private List<String> metrics;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Filter {
        private String type = "or";
        private List<Predicate> predicates;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Predicate {
        private String type = "dimension";
        private String dimension = "mediaType";
        private String operator = "matches";
        private String value = "voice";
    }
}
