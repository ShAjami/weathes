package com.teamoptimization;

import java.io.IOException;
import java.time.DayOfWeek;

public class MetOfficeForecasterAdapter implements Forecaster {
    final private MetOfficeForecasterClient Forecaster;
    public MetOfficeForecasterAdapter(MetOfficeForecasterClient forecasterClient) {
        this.Forecaster = forecasterClient;
    }
    @Override
    public Forecaster.Forecast forecast(DayOfWeek day, String place) throws IOException {
        int dayNumber = day.getValue();
        LocatorClient.Location location = new LocatorClient().locationOf(place);
        MetOfficeForecasterClient.Forecast forecast = Forecaster.forecast(dayNumber, location.latitude, location.longitude);
        return new Forecaster.Forecast(forecast.minTemp, forecast.maxTemp, forecast.description);
    }

}
