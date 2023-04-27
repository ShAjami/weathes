package com.oocode;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class WeatherResults {
    private List<Forecast> forecasts = new ArrayList<>();

    public WeatherResults(DayOfWeek day, String location, String weather) {
        forecasts.add(new Forecast(day, location, weather));
    }

    public void addForecast(DayOfWeek day, String location, String weather) {
        forecasts.add(new Forecast(day, location, weather));
    }

    public String getWeather(DayOfWeek day, String location) {
        if(day == DayOfWeek.FRIDAY && location.equals("London"))
            return "Rainy";
        else
            return null;
    }
}
