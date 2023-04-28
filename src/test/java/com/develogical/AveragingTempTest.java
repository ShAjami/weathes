package com.develogical;

import com.teamoptimization.AveragerForecasterTemps;
import com.teamoptimization.Forecaster;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.time.DayOfWeek;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class AveragingTempTest {

    @Test
    public void averagingForcasterTemp() throws IOException {
        Forecaster forecaster1 = mock(Forecaster.class);
        Forecaster forecaster2 = mock(Forecaster.class);

        Mockito.when(forecaster1.forecast(DayOfWeek.THURSDAY, "Oxford"))
                .thenReturn(new Forecaster.Forecast(5, 10, "sunny"));
        Mockito.when(forecaster2.forecast(DayOfWeek.THURSDAY, "Oxford"))
                .thenReturn(new Forecaster.Forecast(7, 12, "sunny"));
        Forecaster forecaster = new AveragerForecasterTemps( new Forecaster[]{forecaster1, forecaster2});
        Forecaster.Forecast forecast = forecaster.forecast(DayOfWeek.THURSDAY, "Oxford");
        assertEquals(forecast.minTemp, 6);
        assertEquals(forecast.maxTemp, 11);
    }

}
