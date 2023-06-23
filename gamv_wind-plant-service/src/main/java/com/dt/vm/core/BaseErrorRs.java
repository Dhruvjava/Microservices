package com.dt.vm.core;

import com.dt.vm.common.ErrorRs;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseErrorRs implements Serializable {

    private static final long serialVersionUID = -8101327695273217603L;

    private String code;

    private String message;

    private List<ErrorRs> errors = Collections.emptyList();

}
