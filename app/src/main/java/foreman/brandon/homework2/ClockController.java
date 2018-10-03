package foreman.brandon.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class ClockController {
    private Clock clock;
    private ClockAdapter clockAdapter;

    public ClockController() {
    }

    // add new clock model
    public void registerClock(Clock clock) {
        this.clock = clock;
    }

    public void addClockView(int clockType) {
        // digital clock
        // Note to self, use enums here instead of hard coded value
        if(clockType == 1) {
            clockAdapter.addNewView(1);
        }
        // analog clock
        else {

        }
        clockAdapter.notifyDataSetChanged();
    }

    // get clock model time
    public DateTime getClockTime() {
        return clock.getTime();
    }

    // set clock model time
    public void setClockTime(DateTime date) {
        clock.setTime(date);
    }

    // set adapter for list view
    public void registerClockViewListAdapter(ClockAdapter clockAdapter) {
        this.clockAdapter = clockAdapter;
    }

    // update all clocks in list view to in sync with new clock model time
    public void updateClockViews() {
        clockAdapter.setDateTime(clock.getTime());
        clockAdapter.notifyDataSetChanged();
    }
}
