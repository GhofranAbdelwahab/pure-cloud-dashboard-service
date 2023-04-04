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
        private Type type;
        private Stats stats;

        public String getMetric() {
            return metric.substring(1);
        }

        public Type getType() {
            return Type.valueOf(this.getMetric());
        }

        public enum Type {
            Offered, Answered, Abandon
        }
    }

    @lombok.Data
    public static class Stats {
        private Integer count;
    }
}
