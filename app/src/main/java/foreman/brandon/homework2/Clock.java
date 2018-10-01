package foreman.brandon.homework2;

public class Clock {

    private ClockController clockController;
    private DateTime currentTime;

    public Clock(ClockController clockController, DateTime time) {
        this.clockController = clockController;
        currentTime = time;
    }

    public DateTime getTime() {
        return currentTime;
    }

    public void setTime(DateTime time) {
        this.currentTime = time;
        clockController.updateClockViews();
    }
}
