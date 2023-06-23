package com.dt.vm.common;

import com.dt.constants.StringConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class DocIdNameRs implements Serializable {

    private static final long serialVersionUID = -4441996416869690126L;

    private String docId = StringConstants.EMPTY;

    private String name = StringConstants.EMPTY;

    private String enabled;

}
