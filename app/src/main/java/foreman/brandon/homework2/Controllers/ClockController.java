package foreman.brandon.homework2.Controllers;

import java.util.Calendar;

import foreman.brandon.homework2.Models.Clock;
import foreman.brandon.homework2.Views.ClockAdapter;

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
            size = clockAdapter.addNewView(2);
        }
        clockAdapter.notifyDataSetChanged();
        return size;
    }

    public void removeClockView(int position) {
        clockAdapter.removeView(position);
        clockAdapter.notifyDataSetChanged();
    }


    // get clock model time
    public Calendar getClockTime() {
        return clock.getTime();
    }

    // set clock model time
    public void setClockTime(Calendar calendar) {
        clock.setTime(calendar);
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
