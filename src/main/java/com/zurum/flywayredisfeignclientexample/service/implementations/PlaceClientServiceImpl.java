package com.zurum.flywayredisfeignclientexample.service.implementations;

import com.zurum.flywayredisfeignclientexample.client.PlaceClient;
import com.zurum.flywayredisfeignclientexample.dto.request.Root;
import com.zurum.flywayredisfeignclientexample.service.PlaceClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlaceClientServiceImpl implements PlaceClientService {

    private final PlaceClient placeClient;

    @Override
    public Root getPlacesInUs(String id) {
        return placeClient.getPlacesInUs(id);
    }
}
