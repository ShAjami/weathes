package com.teamoptimization;

import java.io.IOException;
import java.time.DayOfWeek;

public class AveragerForecasterTemps implements Forecaster {
    private final Forecaster forecaster1;
    private final Forecaster forecaster2;
    public AveragerForecasterTemps(Forecaster[] Forcasters) {
        this.forecaster1 = Forcasters[0];
        this.forecaster2 = Forcasters[1];
    }

    @Override
    public Forecast forecast(DayOfWeek day, String place) throws IOException {
        Forecaster.Forecast forecast1 = forecaster1.forecast(day, place);
        Forecaster.Forecast forecast2 = forecaster2.forecast(day, place);
        int min = (forecast1.minTemp + forecast2.minTemp) / 2;
        int max = (forecast1.maxTemp + forecast2.maxTemp) / 2;
        return new Forecaster.Forecast(min, max, forecast1.description);
    }
}
