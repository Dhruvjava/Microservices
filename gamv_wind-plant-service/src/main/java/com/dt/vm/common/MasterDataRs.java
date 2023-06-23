package com.dt.vm.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MasterDataRs {

    private String key;

    private List<OptionRs> options = Collections.emptyList();

}
