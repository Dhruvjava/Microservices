package com.dt.gamv.summary.data.rs;

import com.dt.gamv.summary.rs.SummaryRs;
import com.dt.vm.core.BaseDataRs;

import java.util.List;

public class SummaryDataRs extends BaseDataRs {

    private List<SummaryRs> summary;

    public SummaryDataRs(String message, List<SummaryRs> summary) {
        super(message);
        this.summary = summary;
    }

    public SummaryDataRs(String message) {
        super(message);
    }
}
