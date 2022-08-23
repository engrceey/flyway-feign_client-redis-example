package com.zurum.flywayredisfeignclientexample.controller;

import com.zurum.flywayredisfeignclientexample.dto.request.Root;
import com.zurum.flywayredisfeignclientexample.dto.response.ApiResponse;
import com.zurum.flywayredisfeignclientexample.service.PlaceClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class FeignPlaceController {

    private final PlaceClientService placeClientService;

    @GetMapping(path = "/{placeId}")
    public ResponseEntity<ApiResponse<?>> getCustomerByCustomerId(@PathVariable("placeId") final String placeId) {
        log.info("fetch place: By ID:: [{}] ::", placeId);
        Root response = placeClientService.getPlacesInUs(placeId);
        return ResponseEntity.ok().body(ApiResponse.buildSuccess(response));
    }
}
