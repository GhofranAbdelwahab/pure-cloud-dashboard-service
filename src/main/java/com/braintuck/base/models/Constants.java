package com.braintuck.base.models;


public class Constants {
    private Constants() {
    }

    public static final String PURE_CLOUD_LOGIN_BEAN ="PURE_CLOUD_LOGIN";
    public static final String PURE_CLOUD_LOGIN_BASE_URL ="https://login.mypurecloud.de";
    public static final String PURE_CLOUD_LOGIN_PATH_AUTH ="/oauth/token";

    public static final String PURE_CLOUD_DASHBOARD ="PURE_CLOUD_DASHBOARD";
    public static final String PURE_CLOUD_DASHBOARD_BASE_URL ="https://api.mypurecloud.de";
    public static final String PURE_CLOUD_DASHBOARD_PATH_QUERY ="/api/v2/analytics/conversations/aggregates/query";
}
