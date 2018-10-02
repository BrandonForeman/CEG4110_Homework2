package foreman.brandon.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class ClockController {
    private Clock clock;
    private ArrayList<ClockView> clockViews;

    public ClockController() {
        clockViews = new ArrayList<ClockView>();
    }

    public void registerClock(Clock clock) {
        this.clock = clock;
    }

    public void registerClockView(ClockView clockView) {
        clockViews.add(clockView);
    }

    public DateTime getClockTime() {
        return clock.getTime();
    }

    public void setClockTime(DateTime date) {
        clock.setTime(date);
    }

    public void updateClockViews() {
        for (ClockView clockView : clockViews) {
            clockView.setDateTime(clock.getTime());
        }
    }
}
