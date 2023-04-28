package com.develogical;

import com.teamoptimization.CacheForecaster;
import com.teamoptimization.Forecaster;
import org.junit.Test;

import java.io.IOException;
import java.time.DayOfWeek;
import static org.mockito.Mockito.*;

public class CacheForecasterTest {

    @Test
    public void getsForecastFromforcasterIfNeverSeenBefore() throws IOException {
        Forecaster forcaster = mock(Forecaster.class);
        CacheForecaster cf = new CacheForecaster(forcaster);
        cf.forecast(DayOfWeek.WEDNESDAY, "Oxford");
        verify(forcaster).forecast(DayOfWeek.WEDNESDAY, "Oxford");
    }

    @Test
    public void getsForecastFromforcasterIfSeenBefore() throws IOException {
        Forecaster forcaster = mock(Forecaster.class);
        Forecaster cf = new CacheForecaster(forcaster);

        cf.forecast(DayOfWeek.WEDNESDAY, "Oxford");
        cf.forecast(DayOfWeek.WEDNESDAY, "Oxford");

        verify(forcaster, times(1)).forecast(DayOfWeek.WEDNESDAY, "Oxford");
    }

    @Test
    public void getsForecastFromforcasterIfSeenMultipleBefore() throws IOException {
        Forecaster forcaster = mock(Forecaster.class);

        CacheForecaster cf = new CacheForecaster(forcaster);
        cf.forecast(DayOfWeek.WEDNESDAY, "Oxford");
        cf.forecast(DayOfWeek.THURSDAY, "London");
        cf.forecast(DayOfWeek.WEDNESDAY, "Oxford");
        cf.forecast(DayOfWeek.THURSDAY, "London");

        verify(forcaster, times(2)).forecast(any(), any());
    }

    @Test
    public void cacheLimitIsReached() throws IOException {
        Forecaster forcaster = mock(Forecaster.class);

        CacheForecaster cf = new CacheForecaster(forcaster);
        cf.forecast(DayOfWeek.THURSDAY, "London");
        cf.forecast(DayOfWeek.THURSDAY, "London");
        cf.forecast(DayOfWeek.THURSDAY, "London");
        cf.forecast(DayOfWeek.THURSDAY, "London");
        cf.forecast(DayOfWeek.THURSDAY, "London");
        cf.forecast(DayOfWeek.THURSDAY, "London");
        cf.forecast(DayOfWeek.THURSDAY, "London");
        cf.forecast(DayOfWeek.THURSDAY, "London");
        verify(forcaster, times(3)).forecast(any(), any());
    }
  }