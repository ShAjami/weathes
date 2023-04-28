package com.teamoptimization;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class CacheForecaster implements Forecaster {


    final private Map<String, Forecaster.Forecast> cache = new HashMap<>();
    final private Forecaster forcaster;
    public CacheForecaster(Forecaster delegate) {
        this.forcaster = delegate;
    }

    @Override
    public Forecaster.Forecast forecast(DayOfWeek day, String location) throws IOException {
        String key = day.toString() + location;
        if (!cache.containsKey(key)) {
            Forecaster.Forecast result = forcaster.forecast(day, location);
            cache.put(key, result);
        }
        return cache.get(key);
    }
}
