package com.zurum.flywayredisfeignclientexample.config;

public class Routes {

    public static class CustomerClient {
        public static final String GET_CUSTOMER = "/core/finance";
    }

    public static class PlaceClient {
        public static final String GET_PLACES_BY_ID = "us/{id}";
    }
}
