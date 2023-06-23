package com.dt.exception;

import com.dt.vm.common.ErrorRs;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlantException extends Exception {

    List<ErrorRs> errors;

    private String errorCode;

    public PlantException(String message, List<ErrorRs> errors) {
        super(message);
        this.errorCode = message;
        this.errors = errors;
    }

    public PlantException(String message) {
        super(message);
        this.errorCode = message;
    }
}
