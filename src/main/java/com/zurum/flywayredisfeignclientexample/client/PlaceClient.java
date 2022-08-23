package com.zurum.flywayredisfeignclientexample.client;

import com.zurum.flywayredisfeignclientexample.config.Routes;
import com.zurum.flywayredisfeignclientexample.dto.request.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "zurum-flyway-feign-place-client", url = "https://api.zippopotam.us/")
public interface PlaceClient {

        @GetMapping(path = Routes.PlaceClient.GET_PLACES_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
        Root getPlacesInUs(@PathVariable("id") final String id);
}
