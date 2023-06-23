package com.dt.gamv.summary.service.impl;

import com.dt.constants.StringConstants;
import com.dt.exception.SummaryException;
import com.dt.gamv.summary.PlantClient;
import com.dt.gamv.summary.bo.SummaryBO;
import com.dt.gamv.summary.constants.ErrorCodes;
import com.dt.gamv.summary.constants.MessageCodes;
import com.dt.gamv.summary.data.rs.SummaryDataRs;
import com.dt.gamv.summary.mapper.SummaryMapper;
import com.dt.gamv.summary.repo.SummaryRepo;
import com.dt.gamv.summary.rq.IdRq;
import com.dt.gamv.summary.rs.SummaryRs;
import com.dt.gamv.summary.service.SummaryService;
import com.dt.utils.MessageBundles;
import com.dt.utils.Utils;
import com.dt.vm.core.BaseRs;
import com.dt.vm.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    private SummaryRepo summaryRepo;

    @Autowired
    private PlantClient plantClient;

    @Override
    public BaseRs retrieveSummary(IdRq rq) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Executing retrieveSummary(IdRq rq) ->");
        }
        try {
            if (Utils.isEmpty(rq.code())) {
                throw new SummaryException(ErrorCodes.EC_REQUIRED_CODE);
            }
            String pCode = Utils.getValidString(rq.code());
            String message = StringConstants.EMPTY;
            ResponseEntity<BaseRs> plantResponse = plantClient.findPlant(pCode);
            if (!plantResponse.getStatusCode().equals(HttpStatus.OK)) {
                throw new SummaryException(ErrorCodes.EC_INVALID_CODE);
            }
            List<SummaryBO> summaryBOS = summaryRepo.findSummaryByPcode(pCode);
            if (Utils.isEmpty(summaryBOS)) {
                message = MessageBundles.getMessage(MessageCodes.MC_NO_RECORDS_FOUND);
                return ResponseUtils.success(new SummaryDataRs(message));
            }
            List<SummaryRs> summaryRSs = SummaryMapper.mapToSummaryRSs(summaryBOS);
            message = MessageBundles.getMessage(MessageCodes.MC_RETRIEVED_SUCCESSFUL);
            return ResponseUtils.success(new SummaryDataRs(message, summaryRSs));
        } catch (Exception e) {
            log.error("Exception in retrieveSummary(IdRq rq) -> {0}", e);
            throw e;
        }
    }
}
