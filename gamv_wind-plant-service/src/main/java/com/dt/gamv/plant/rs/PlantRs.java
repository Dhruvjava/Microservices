package com.dt.gamv.plant.rs;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record PlantRs(String code, String name, String state, Double capacity) implements Serializable {
}

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//public class PlantRs implements Serializable {
//
//    private String code;
//
//    private String name;
//
//    private String state;
//
//    private String capacity;
//}
