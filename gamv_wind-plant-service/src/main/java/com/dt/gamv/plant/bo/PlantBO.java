package com.dt.gamv.plant.bo;


import com.dt.core.BaseBO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "plants")
public class PlantBO extends BaseBO {

//    @Id
    private String code;

    private String name;

    private String state;

    private Double capacity;

    public PlantBO(String createdBy) {
        super(createdBy);
    }
}
