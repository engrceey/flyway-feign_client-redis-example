package com.zurum.flywayredisfeignclientexample.service;

import com.zurum.flywayredisfeignclientexample.dto.request.Root;

public interface PlaceClientService {
    Root getPlacesInUs(String id);
}
