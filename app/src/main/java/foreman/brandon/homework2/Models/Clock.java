package foreman.brandon.homework2.Models;

import java.util.Calendar;

import foreman.brandon.homework2.Controllers.ClockController;

public class Clock {

    private ClockController clockController;
    private Calendar calendar;

    public Clock(ClockController clockController, Calendar calendar) {
        this.clockController = clockController;
        this.calendar = calendar;
    }

    public Calendar getTime() {
        return calendar;
    }

    public void setTime(Calendar calendar) {
        this.calendar = calendar;
        clockController.updateClockViews();
    }
}
