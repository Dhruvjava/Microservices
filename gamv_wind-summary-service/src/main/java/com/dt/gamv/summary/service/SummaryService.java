package com.dt.gamv.summary.service;

import com.dt.gamv.summary.rq.IdRq;
import com.dt.gamv.summary.rs.SummaryRs;
import com.dt.vm.core.BaseRs;

import java.util.List;

public interface SummaryService {

    public BaseRs retrieveSummary(IdRq rq) throws Exception;
}
