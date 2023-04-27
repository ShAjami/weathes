package com.oocode;

import org.junit.Test;

import java.time.DayOfWeek;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CacheForecasterTest {

    @Test
    public void getsForecastFromDelegateIfNeverSeenBefore() {
        Forecaster delegate = mock(Forecaster.class);
        given(delegate.forecast(DayOfWeek.WEDNESDAY, "Oxford")).willReturn("Sunny");
        CacheForecaster cf = new CacheForecaster(delegate);

        String forecast = cf.forecast(DayOfWeek.WEDNESDAY, "Oxford");

        assertTrue(forecast.equals("Sunny"));
        verify(delegate).forecast(DayOfWeek.WEDNESDAY, "Oxford");
    }

    @Test
    public void getsForecastFromDelegateIfSeenBefore() {
        Forecaster delegate = mock(Forecaster.class);
        given(delegate.forecast(DayOfWeek.WEDNESDAY, "Oxford")).willReturn("Sunny");
        CacheForecaster cf = new CacheForecaster(delegate);
        String forecast = cf.forecast(DayOfWeek.WEDNESDAY, "Oxford");
        String forecast2 = cf.forecast(DayOfWeek.WEDNESDAY, "Oxford");

        assertTrue(forecast.equals("Sunny"));
        verify(delegate, times(1)).forecast(DayOfWeek.WEDNESDAY, "Oxford");
    }

    @Test
    public void getsForecastFromDelegateIfSeenMultipleBefore() {
        Forecaster delegate = mock(Forecaster.class);
        given(delegate.forecast(DayOfWeek.WEDNESDAY, "Oxford")).willReturn("Sunny");
        given(delegate.forecast(DayOfWeek.THURSDAY, "London")).willReturn("Rain");

        CacheForecaster cf = new CacheForecaster(delegate);
        String forecast = cf.forecast(DayOfWeek.WEDNESDAY, "Oxford");
        String forecast3 = cf.forecast(DayOfWeek.THURSDAY, "London");
        String forecast2 = cf.forecast(DayOfWeek.WEDNESDAY, "Oxford");
        String forecast4 = cf.forecast(DayOfWeek.THURSDAY, "London");

        verify(delegate, times(2)).forecast(any(), any());
//        verify(delegate, times(1)).forecast(DayOfWeek.THURSDAY, "London");
    }
  }