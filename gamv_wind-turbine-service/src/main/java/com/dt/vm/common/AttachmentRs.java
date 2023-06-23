package com.dt.vm.common;

import java.io.Serializable;

import com.dt.constants.StringConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class AttachmentRs implements Serializable {

    private static final long serialVersionUID = -4441996416869690126L;

    private String docId = StringConstants.EMPTY;

    private String name = StringConstants.EMPTY;

    private String title = StringConstants.EMPTY;

    private String type = StringConstants.EMPTY;

    private String by = StringConstants.EMPTY;

    private String on = StringConstants.EMPTY;

    private String description = StringConstants.EMPTY;

    public AttachmentRs(String docId, String name, String type) {
        super();
        this.docId = docId;
        this.name = name;
        this.type = type;
    }

}
