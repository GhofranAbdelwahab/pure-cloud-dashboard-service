package com.braintuck.base.models.request;

import com.braintuck.base.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Data
@Valid
@AllArgsConstructor
public class DashboardRequest {
    private String interval;
    private Filter filter;
    private List<String> metrics;

    public DashboardRequest() {
        this.interval = DateUtils.buildInverterOfCurrentDay();
        this.filter = new Filter();
        this.metrics = Arrays.asList("tAbandon", "tAnswered", "nOffered", "tFlowOut");
    }

    @Data
    @AllArgsConstructor
    public static class Filter {
        private String type = "or";
        private List<Predicate> predicates;

        public Filter() {
            this.type = "or";
            this.predicates = Collections.singletonList(new Predicate());
        }
    }

    @Data
    @AllArgsConstructor
    public static class Predicate {
        private String type;
        private String dimension;
        private String operator;
        private String value;

        public Predicate() {
            this.type = "dimension";
            this.dimension = "mediaType";
            this.operator = "matches";
            this.value = "voice";

        }
    }
}
