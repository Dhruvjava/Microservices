package com.dt.gamv.turbine.data.rs;

import com.dt.gamv.turbine.rs.TurbinesRs;
import com.dt.vm.core.BaseDataRs;

import java.util.List;

public class TurbinesDataRs extends BaseDataRs {

    private List<TurbinesRs> turbines;

    public TurbinesDataRs(String message, List<TurbinesRs> turbines) {
        super(message);
        this.turbines = turbines;
    }

    public TurbinesDataRs(String message) {
        super(message);
    }
}
