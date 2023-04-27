package com.oocode;

import java.time.DayOfWeek;

public class Forecast {
    private String query;
    private String weather;

    public Forecast(String query, String weather) {
        this.query = query;
        this.weather = weather;
    }

    public String query() {
        return query;
    }

    public String getWeather() {
        return weather;
    }
}
