package foreman.brandon.homework2.Models;

import java.util.Calendar;

import foreman.brandon.homework2.Controllers.ClockController;

public class Clock {

    private ClockController clockController;
    private Calendar time;

    public Clock(ClockController clockController, Calendar time) {
        this.clockController = clockController;
        this.time = time;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar calendar) {
        this.time = calendar;
        clockController.updateClockViews();
    }
}
