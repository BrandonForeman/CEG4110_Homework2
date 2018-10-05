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

    /*
    * Adds a clock view to the clock list view
    * Param: Type of clock to create
    * Returns: Index of clock added in clock list view
    * */
    public int addClockView(Integer clockType) {
        // digital clock
        // Note to self, use enums here instead of hard coded value
        int size = 0;
        if(clockType == 1) {
            size = clockAdapter.addNewView(1);
        }
        // analog clock
        else {

        }
        clockAdapter.notifyDataSetChanged();
        return size;
    }

    public void removeClockView(int position) {
        clockAdapter.removeView(position);
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
