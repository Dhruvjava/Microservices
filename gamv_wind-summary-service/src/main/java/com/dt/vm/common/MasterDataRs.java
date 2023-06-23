package com.dt.vm.common;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MasterDataRs {

    private String key;

    private List<OptionRs> options = Collections.emptyList();

}
