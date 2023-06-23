package com.dt.gamv.plant.service;

import com.dt.gamv.plant.rq.IdRq;
import com.dt.vm.core.BaseRs;

public interface PlantService {

//    BaseRs savePlant(PlantRq rq) throws Exception;

    BaseRs retrievePlant() throws Exception;

    BaseRs findPlant(IdRq rq) throws Exception;
}
