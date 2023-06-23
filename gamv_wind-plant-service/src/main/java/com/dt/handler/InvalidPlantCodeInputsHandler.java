package com.dt.handler;

import com.dt.exception.PlantException;
import com.dt.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidPlantCodeInputsHandler {

    @ExceptionHandler(PlantException.class)
    public ResponseEntity<ProblemDetail> handleInvalidPlantRqInputs(PlantException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ProblemDetail problemDetail = ProblemDetail.forStatus(status.value());
        problemDetail.setTitle(e.getErrorCode());
        problemDetail.setStatus(status);
        problemDetail.setDetail(e.getErrorCode());
        if (Utils.isNotEmpty(e.getErrors())) {
            problemDetail.setProperty("errors", e.getErrors());
        }

        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_PROBLEM_JSON)
                        .body(problemDetail);
    }
}
