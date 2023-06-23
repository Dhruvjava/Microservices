package com.dt.gamv.summary.rs;

import java.time.LocalDateTime;

public record SummaryRs(String code, String name, String status, LocalDateTime dataTime, Double ap,
                        Double ws, Double np) {
}
