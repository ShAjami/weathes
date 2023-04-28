package com.oocode;

import com.teamoptimization.*;
import com.teamoptimization.MetOfficeForecasterClient;
import com.teamoptimization.NavyForecastingClient;

import java.io.IOException;
import java.time.DayOfWeek;

public class Example {
    public static void main(String[] args) throws IOException {
        args = new String[]{"Monday", "London"};
        MetOfficeForecasterClient MetClient = new MetOfficeForecasterClient();
        Forecaster MetAdapter = new MetOfficeForecasterAdapter(MetClient);
        Forecaster forecastRequest = new CacheForecaster(MetAdapter);

        forecastPrint(args[0], args[1], MetAdapter);
        forecastPrint(args[0], args[1], MetAdapter);
        forecastPrint(args[0], args[1], MetAdapter);
        forecastPrint(args[0], args[1], MetAdapter);
        forecastPrint(args[0], args[1], MetAdapter);

        forecastPrint(args[0], args[1], forecastRequest);
        forecastPrint(args[0], args[1], forecastRequest);
        forecastPrint(args[0], args[1], forecastRequest);
        forecastPrint(args[0], args[1], forecastRequest);
        forecastPrint(args[0], args[1], forecastRequest);
        forecastPrint(args[0], args[1], forecastRequest);
        forecastPrint(args[0], args[1], forecastRequest);
        forecastPrint(args[0], args[1], forecastRequest);
        forecastPrint(args[0], args[1], forecastRequest);
        forecastPrint(args[0], args[1], forecastRequest);

        NavyForecastingClient NavyClient = new NavyForecastingClient();
        Forecaster NavyAdapter = new NavyForecasterAdapter(NavyClient);
        Forecaster forecastNavyRequest = new CacheForecaster(NavyAdapter);

        forecastPrint(args[0], args[1], NavyAdapter);
        forecastPrint(args[0], args[1], NavyAdapter);
        forecastPrint(args[0], args[1], NavyAdapter);
        forecastPrint(args[0], args[1], NavyAdapter);
        forecastPrint(args[0], args[1], NavyAdapter);

        forecastPrint(args[0], args[1], forecastNavyRequest);
        forecastPrint(args[0], args[1], forecastNavyRequest);
        forecastPrint(args[0], args[1], forecastNavyRequest);
        forecastPrint(args[0], args[1], forecastNavyRequest);
        forecastPrint(args[0], args[1], forecastNavyRequest);

        forecastPrint(args[0], args[1], new AveragerForecasterTemps(new Forecaster[]{forecastNavyRequest, forecastRequest}));
    }

    private static void forecastPrint(String day, String place, Forecaster forecastRequest) throws IOException {
        Forecaster.Forecast weather =
                forecastRequest.forecast(DayOfWeek.valueOf(day.toUpperCase()), place);
        System.out.printf("forecaster: %s day=%s min=%s max=%s description=%s%n",
                place, day, weather.minTemp, weather.maxTemp, weather.description);
    }

}

