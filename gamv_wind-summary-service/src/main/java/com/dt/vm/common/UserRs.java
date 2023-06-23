package com.dt.vm.common;

import java.io.Serializable;

import com.dt.constants.StringConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRs implements Serializable {

    private static final long serialVersionUID = -4441996416869690126L;

    private String username = StringConstants.EMPTY;

    private String userDocId = StringConstants.EMPTY;
    
    private String profileDocId = StringConstants.EMPTY;

}
