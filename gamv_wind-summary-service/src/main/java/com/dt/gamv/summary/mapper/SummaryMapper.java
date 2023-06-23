package com.dt.gamv.summary.mapper;

import com.dt.gamv.summary.bo.SummaryBO;
import com.dt.gamv.summary.rs.SummaryRs;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class SummaryMapper {

    private SummaryMapper() {
    }

    public static List<SummaryRs> mapToSummaryRSs(List<SummaryBO> summaryBOS) {
        if (log.isDebugEnabled()) {
            log.debug("Executing mapToSummaryRSs(List<SummaryBO> summaryBOS) -> ");
        }
        try {
            List<SummaryRs> summaryRSs = new ArrayList<>();
            summaryBOS.forEach(summaryBO -> {
                SummaryRs summaryRs = mapToSummaryRs(summaryBO);
                if (summaryRs != null) {
                    summaryRSs.add(summaryRs);
                }
            });
            return summaryRSs;
        } catch (Exception e) {
            log.error("Exception in mapToSummaryRSs(List<SummaryBO> summaryBOS) -> {0}", e);
            return Collections.emptyList();
        }
    }

    public static SummaryRs mapToSummaryRs(SummaryBO summaryBO) {
        if (log.isDebugEnabled()) {
            log.debug("Executing mapToSummaryRs(SummaryBO summaryBO) ->");
        }
        try {
            if (summaryBO == null) {
                return null;
            }
            return new SummaryRs(summaryBO.getTcode(), summaryBO.getTname(), summaryBO.getTstatus(),
                            summaryBO.getDataTime(), summaryBO.getAp(), summaryBO.getWs(),
                            summaryBO.getNp());

        } catch (Exception e) {
            log.error("Exception in mapToSummaryRs(SummaryBO summaryBO) -> {0}", e);
            return null;
        }
    }
}
