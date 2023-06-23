package com.dt.gamv.plant.service.impl;

import com.dt.constants.StringConstants;
import com.dt.exception.PlantException;
import com.dt.gamv.plant.bo.PlantBO;
import com.dt.gamv.plant.constants.ErrorCodes;
import com.dt.gamv.plant.constants.MessageCodes;
import com.dt.gamv.plant.data.rs.PlantDataRSs;
import com.dt.gamv.plant.data.rs.PlantDataRs;
import com.dt.gamv.plant.mapper.PlantMapper;
import com.dt.gamv.plant.repo.PlantRepo;
import com.dt.gamv.plant.rq.IdRq;
import com.dt.gamv.plant.rs.PlantRs;
import com.dt.gamv.plant.service.PlantService;
import com.dt.utils.MessageBundles;
import com.dt.utils.Utils;
import com.dt.vm.core.BaseRs;
import com.dt.vm.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantRepo plantRepo;

    @Override
    public BaseRs retrievePlant() throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Executing retrievePlant() ->");
        }
        try {
            String message = StringConstants.EMPTY;
            List<PlantBO> plantBOS = plantRepo.retrievePlants();
            if (Utils.isEmpty(plantBOS)) {
                message = MessageBundles.getMessage(MessageCodes.MC_NO_RECORDS_FOUND);
                return ResponseUtils.success(new PlantDataRSs(message));
            }
            List<PlantRs> plants = PlantMapper.mapToPlantRSs(plantBOS);
            message = MessageBundles.getMessage(MessageCodes.MC_RETRIEVED_SUCCESSFUL);
            return ResponseUtils.success(new PlantDataRSs(message, plants));
        } catch (Exception e) {
            log.error("Exception in retrievePlant() -> {0}", e);
            throw e;
        }
    }

    @Override
    public BaseRs findPlant(IdRq rq) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Executing findPlant(rq)");
        }
        try {
            String pcode = Utils.getValidString(rq.code());
            Optional<PlantBO> plantOpt = plantRepo.findByPcodeAndEnabledIsTrue(pcode);
            PlantBO plantBO = null;
            if (plantOpt.isPresent()) {
                plantBO = plantOpt.get();
            } else {
                throw new PlantException(ErrorCodes.EC_PLANT_NOT_FOUND);
            }
            String message = MessageBundles.getMessage(MessageCodes.MC_RETRIEVED_SUCCESSFUL);
            PlantRs plantRs = PlantMapper.mapToPlantRs(plantBO);
            return ResponseUtils.success(new PlantDataRs(message, plantRs));
        } catch (Exception e) {
            log.error("Exception in findPlant(rq) -> {0}", e);
        }
        return null;
    }
}
