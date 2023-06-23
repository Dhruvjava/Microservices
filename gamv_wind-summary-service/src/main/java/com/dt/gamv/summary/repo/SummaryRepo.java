package com.dt.gamv.summary.repo;

import com.dt.gamv.summary.bo.SummaryBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface SummaryRepo extends JpaRepository<SummaryBO, String> {

    @Procedure(procedureName = "GetRecentTurbinesSummary")
    public List<SummaryBO> findSummaryByPcode(String code);
}
