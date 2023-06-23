package com.dt.gamv.summary;

import com.dt.vm.core.BaseRs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PLANT-SERVICE")
public interface PlantClient {

    @GetMapping("/api/plant/{code}")
    public ResponseEntity<BaseRs> findPlant(@PathVariable String code);

}
