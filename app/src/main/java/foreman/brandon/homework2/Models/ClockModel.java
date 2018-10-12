package foreman.brandon.homework2.Models;

import java.util.Calendar;

import foreman.brandon.homework2.Controllers.ClockController;

public class ClockModel {

    private ClockController clockController;
    private Calendar time;

    public ClockModel(Calendar time) {
        this.time = time;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar calendar) {
        this.time = calendar;
        // tell the clock controller to update its views since the model changed
        clockController.updateClockViews();
    }

    public void registerClockController(ClockController clockController) {
        this.clockController = clockController;
    }
}
