package com.amaris.technicaltest.client;

import com.amaris.technicaltest.persistence.entity.CommuneEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "COMMUNE-MOCK-API", url = "${external.mock.api.base-url}")
public interface CommuneClient {

    @GetMapping(value = "/comunas", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<CommuneEntity> getAll();
}
