package com.dt.gamv.plant.mapper;

import com.dt.gamv.plant.bo.PlantBO;
import com.dt.gamv.plant.constants.ErrorCodes;
import com.dt.gamv.plant.rs.PlantRs;
import com.dt.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class PlantMapper {

    private PlantMapper() {
    }

    public static List<PlantRs> mapToPlantRSs(List<PlantBO> plantBOS) {
        if (log.isDebugEnabled()) {
            log.debug("Executing mapToPlantRSs(plantBOS)");
        }
        try {
            if (Utils.isEmpty(plantBOS)) {
                log.warn(ErrorCodes.EC_EMPTY_PLANTS);
                return Collections.emptyList();
            }
            List<PlantRs> plantRSs = new ArrayList<>();
            plantBOS.forEach(plantBO -> {
                PlantRs plantRs = mapToPlantRs(plantBO);
                if (plantRs != null) {
                    plantRSs.add(plantRs);
                }
            });
            return plantRSs;
        } catch (Exception e) {
            log.error("Exception in mapToPlantRSs(plantBOS) -> ");
            return Collections.emptyList();
        }
    }

    public static PlantRs mapToPlantRs(PlantBO plantBO) {
        if (log.isDebugEnabled()) {
            log.debug("Executing mapToPlantRs(plantBO)");
        }
        try {
            if (plantBO == null) {
                log.warn(ErrorCodes.EC_EMPTY_PLANTS);
                return null;
            }
            return new PlantRs(plantBO.getCode(), plantBO.getName(), plantBO.getState(),
                            plantBO.getCapacity());
        } catch (Exception e) {
            log.error("Exception in mapToPlantRs(plantBO) -> {0}", e);
            return null;
        }
    }

}
