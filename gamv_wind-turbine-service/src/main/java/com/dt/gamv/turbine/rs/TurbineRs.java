package com.dt.gamv.turbine.rs;

import java.time.LocalDateTime;

public record TurbineRs(String name, String code, int status, LocalDateTime dataTime, Double ap,
                        Double ws, Double np) {
}
