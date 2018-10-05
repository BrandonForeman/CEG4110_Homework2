package foreman.brandon.homework2;

public class SetClockTime implements Command {
    private ClockController clockController;
    private DateTime previousDateTime, newDateTime;

    public SetClockTime(ClockController clockController, DateTime previousDateTime, DateTime newDateTime) {
        this.clockController = clockController;
        this.previousDateTime = previousDateTime;
        this.newDateTime = newDateTime;
    }

    @Override
    public void doIt() {
        clockController.setClockTime(newDateTime);
    }

    @Override
    public void undoIt() {
        clockController.setClockTime(previousDateTime);
    }
}
