package com.dt.vm.core;

import com.dt.constants.StringConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseRq extends BaseVM {

    private static final long serialVersionUID = 85381423028274032L;

    @JsonIgnore
    private String appId = StringConstants.EMPTY;

    @JsonIgnore
    private String clientType = StringConstants.EMPTY;

    @JsonIgnore
    private String username = StringConstants.EMPTY;

    @JsonIgnore
    private String userDocId;

    @JsonIgnore
    private String context = StringConstants.EMPTY;

    @JsonIgnore
    private String deviceModel = StringConstants.EMPTY;

    @JsonIgnore
    private String devicePlatform = StringConstants.EMPTY;

    @JsonIgnore
    private String deviceUuid = StringConstants.EMPTY;

    @JsonIgnore
    private String deviceVersion = StringConstants.EMPTY;

}
