package foreman.brandon.homework2.Commands;

import java.util.Calendar;

import foreman.brandon.homework2.Controllers.ClockController;

public class SetClockTime implements Command {
    private ClockController clockController;
    private Calendar previousCalendar;
    private Calendar newCalendar;

    public SetClockTime(ClockController clockController, Calendar previousCalendar, Calendar newCalendar) {
        this.clockController = clockController;
        this.previousCalendar = previousCalendar;
        this.newCalendar = newCalendar;
    }

    /*
     * Set clock model to new time
     * Param:
     * Returns: void
     * */
    @Override
    public void doIt() {
        clockController.setClockTime(newCalendar);
    }


    /*
     * Set clock model to old time, before command was executed
     * Param:
     * Returns: void
     * */
    @Override
    public void undoIt() {
        clockController.setClockTime(previousCalendar);
    }
}
