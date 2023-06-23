package com.dt.gamv.summary.bo;

import com.dt.core.BaseBO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "summary")
public class SummaryBO extends BaseBO {

    private String pcode;

    private String tcode;

    private String tname;

    private String tstatus;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataTime;

    private Double ap;

    private Double ws;

    private Double np;
}
