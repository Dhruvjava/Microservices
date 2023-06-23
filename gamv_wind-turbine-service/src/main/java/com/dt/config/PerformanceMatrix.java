package com.dt.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;

import java.util.concurrent.TimeUnit;


public class PerformanceMatrix implements ObservationHandler<Observation.Context> {

    private final MeterRegistry meterRegistry;

    private final Timer timer;

    public PerformanceMatrix(MeterRegistry meterRegistery) {
        this.meterRegistry = meterRegistery;
        this.timer = Timer.builder("Method Executution Time")
                        .description("Time Taken To Execute Method").register(meterRegistry);
    }


    @Override
    public void onStart(Observation.Context context) {
        context.put("start", System.nanoTime());
    }

    @Override
    public void onError(Observation.Context context) {
        meterRegistry.counter("Method Errors", "Method", context.getName()).increment();
    }

    @Override
    public void onEvent(Observation.Event event, Observation.Context context) {
        ObservationHandler.super.onEvent(event, context);
    }

    @Override
    public void onScopeOpened(Observation.Context context) {
        ObservationHandler.super.onScopeOpened(context);
    }

    @Override
    public void onScopeClosed(Observation.Context context) {
        ObservationHandler.super.onScopeClosed(context);
    }

    @Override
    public void onScopeReset(Observation.Context context) {
        ObservationHandler.super.onScopeReset(context);
    }

    @Override
    public void onStop(Observation.Context context) {
        Long start = context.get("start");
        if (start != null) {
            long duration = System.nanoTime() - start;
            timer.record(duration, TimeUnit.NANOSECONDS);
        }
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }
}
