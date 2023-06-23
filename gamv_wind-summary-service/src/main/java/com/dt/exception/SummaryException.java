package com.dt.exception;

import com.dt.vm.common.ErrorRs;

import java.util.List;

public class SummaryException extends Exception {

    private String errorCode;

    private List<ErrorRs> errors;

    public SummaryException(String errorCode, List<ErrorRs> errors) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public SummaryException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }
}
