package foreman.brandon.homework2;

import java.util.Calendar;

public class SetClockTime implements Command {
    private ClockController clockController;
    private Calendar previousCalendar;
    private Calendar newCalendar;

    public SetClockTime(ClockController clockController, Calendar previousCalendar, Calendar newCalendar) {
        this.clockController = clockController;
        this.previousCalendar = previousCalendar;
        this.newCalendar = newCalendar;
    }

    @Override
    public void doIt() {
        clockController.setClockTime(newCalendar);
    }

    @Override
    public void undoIt() {
        clockController.setClockTime(previousCalendar);
    }
}
