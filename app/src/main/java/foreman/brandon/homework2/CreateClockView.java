package foreman.brandon.homework2;

public class CreateClockView implements Command {
    private ClockController clockController;
    private int clockType, position;


    public CreateClockView(ClockController clockController, int clockType) {
        this.clockController = clockController;
        this.clockType = clockType;
    }

    @Override
    public void doIt() {
        switch(clockType) {
            case 1:
                // add digital clock
                position = clockController.addClockView(1);
                break;
            case 2:
                // add analog clock
                position = clockController.addClockView(2);
                break;
        }
    }

    @Override
    public void undoIt() {
        clockController.removeClockView(position);
    }
}
