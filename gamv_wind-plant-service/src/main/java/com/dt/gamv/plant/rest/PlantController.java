package com.dt.gamv.plant.rest;

import com.dt.gamv.plant.rq.IdRq;
import com.dt.gamv.plant.service.PlantService;
import com.dt.utils.Utils;
import com.dt.vm.core.BaseRs;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping()
    @Operation(summary = "Retrieve Plants", description = "Retrieve Plants")
    public ResponseEntity<BaseRs> retrievePlants(
                    /* @RequestHeader(value = AppHeader.APP_ID, required = false) String appid*/)
                    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Executing RESTfull Services [GET - /api/plant] ->");
        }
        try {
            BaseRs rs = plantService.retrievePlant();
            return ResponseEntity.ok(rs);
        } catch (Exception e) {
            log.error("Exception in RESTfull Services [GET - /api/plant] -> {0}", e);
            throw e;
        }
    }

    @GetMapping("/{code}")
    public ResponseEntity<BaseRs> findPlant(@PathVariable String code) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Executing RESTfull Services [GET - /api/plant/{code}] ->");
        }
        try {
            IdRq rq = new IdRq(Utils.getValidString(code));
            BaseRs rs = plantService.findPlant(rq);
            return ResponseEntity.ok(rs);
        } catch (Exception e) {
            log.error("Exception in RESTfull Services [GET - /api/plant/{code}] -> {0}", e);
            throw e;
        }
    }
}
