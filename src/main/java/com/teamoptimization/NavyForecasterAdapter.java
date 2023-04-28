package com.teamoptimization;

import java.io.IOException;
import java.time.DayOfWeek;

public class NavyForecasterAdapter implements Forecaster {
    final private NavyForecastingClient Forecaster;
    public NavyForecasterAdapter(NavyForecastingClient forecasterClient) {
        this.Forecaster = forecasterClient;
    }
    @Override
    public Forecast forecast(DayOfWeek day, String place) throws IOException {
        int minTemp = Forecaster.min(day, place);
        int maxTemp = Forecaster.max(day, place);
        String description = Forecaster.desc(day, place);
        return new Forecast(minTemp, maxTemp, description);
    }

}
