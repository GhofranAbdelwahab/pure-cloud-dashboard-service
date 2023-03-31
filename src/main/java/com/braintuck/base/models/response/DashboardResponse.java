package com.braintuck.base.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private List<Result> results;

    @lombok.Data
    public static class Result {
        private Group group;
        private List<Data> data;
    }

    @lombok.Data
    public static class Group {
        private String mediaType;
    }

    @lombok.Data
    public static class Data {
        private String interval;
        private List<Metric> metrics;
    }

    @lombok.Data
    public static class Metric {
        private String metric;
        private Stats stats;
    }

    @lombok.Data
    public static class Stats {
        private Integer count;
//        private Integer max;
//        private Integer min;
//        private Integer sum;
    }
}
