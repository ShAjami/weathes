package com.oocode;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CacheForecaster implements Forecaster {

    Map
    private List<Forecast> results = new ArrayList<>();

    private Forecaster forcaster;
    public CacheForecaster(Forecaster delegate) {
        this.delegate = delegate;
    }

    @Override
    public String forecast(DayOfWeek day, String location) {

//        String search = "a";
//        int searchListLength = results.size();
//        for (int i = 0; i < searchListLength; i++) {
//            if (results.get(i).contains(search)) {
//                result = results.get(i)
//            }
//        }
//        Forecast forecast = results.contains((state) => { state.query ===day.toString()+location return } );
        if(dayQuery != day && locationQuery != location) {
            results.add(new Forecast(day.toString()+location, "Sunny"));
            result = delegate.forecast(day,location);
        }
        return result;
    }
}
