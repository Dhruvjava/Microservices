package com.dt.gamv.plant.data.rs;

import com.dt.gamv.plant.rs.PlantRs;
import com.dt.vm.core.BaseDataRs;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlantDataRSs extends BaseDataRs {

    List<PlantRs> plant;

    public PlantDataRSs(String message, List<PlantRs> plant) {
        super(message);
        this.plant = plant;
    }

    public PlantDataRSs(String message){
        super(message);
    }
}
