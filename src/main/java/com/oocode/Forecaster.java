package com.oocode;

import java.time.DayOfWeek;

interface Forecaster {
    String forecast(DayOfWeek day, String place);

}
