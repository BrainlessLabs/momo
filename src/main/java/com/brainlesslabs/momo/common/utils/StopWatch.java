package com.brainlesslabs.momo.common.utils;

import java.time.Duration;
import java.time.Instant;

public class StopWatch {
    private Instant start = Instant.now();
    private Instant finish = Instant.now();

    public void start(){
        start = Instant.now();
    }

    public void stop() {
        finish = Instant.now();
    }

    public long durationMillis() {
        return Duration.between(start, finish).toMillis();
    }
}
