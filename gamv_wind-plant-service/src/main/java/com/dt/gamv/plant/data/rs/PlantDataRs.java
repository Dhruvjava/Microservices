package com.dt.gamv.plant.data.rs;

import com.dt.gamv.plant.rs.PlantRs;
import com.dt.vm.core.BaseDataRs;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlantDataRs extends BaseDataRs {

    private PlantRs plant;

    public PlantDataRs(String message, PlantRs plant) {
        super(message);
        this.plant = plant;
    }

}
