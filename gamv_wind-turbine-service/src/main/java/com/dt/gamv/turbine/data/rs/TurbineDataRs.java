package com.dt.gamv.turbine.data.rs;

import com.dt.gamv.turbine.rs.TurbineRs;
import com.dt.vm.core.BaseDataRs;

public class TurbineDataRs extends BaseDataRs {

    private TurbineRs turbine;

    public TurbineDataRs(String message, TurbineRs turbine) {
        super(message);
        this.turbine = turbine;
    }

    public TurbineDataRs(String message) {
        super(message);
    }
}
