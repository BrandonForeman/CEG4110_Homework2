package foreman.brandon.homework2.Controllers;

import java.util.Calendar;

import foreman.brandon.homework2.Models.ClockModel;
import foreman.brandon.homework2.Views.ClockAdapter;

public class ClockController {
    private ClockModel clockModel;
    private ClockAdapter clockAdapter;

    public ClockController() {
    }

    /*
     * Register Clock Model
     * Param:
     * Returns: void
     * */
    public void registerClock(ClockModel clockModel) {
        this.clockModel = clockModel;
    }

    /*
    * Adds a clock view to the clock list view
    * Param: Type of clock to create
    * Returns: Index of clock added in clock list view
    * */
    public int addClockView(Integer clockType) {
        // digital clock
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

    /*
     * Removes clock view from adapter array list
     * Param: index of element in adapter array
     * Returns: void
     * */
    public void removeClockView(int position) {
        clockAdapter.removeView(position);
        clockAdapter.notifyDataSetChanged();
    }

    /*
     * Returns number of clocks in adapter array i.e. the list view of clocks
     * Param:
     * Returns: int
     * */
    public int getNumberOfClocks() {
        return clockAdapter.getSize();
    }


    /*
     * Adds returns the current Calendar
     * Param:
     * Returns: Calendar
     * */
    public Calendar getClockTime() {
        return clockModel.getTime();
    }

    // set clock model time
    public void setClockTime(Calendar calendar) {
        clockModel.setTime(calendar);
    }

    /*
     * Registers a clock adapter
     * Param: ClockAdapter
     * Returns:
     * */
    public void registerClockViewListAdapter(ClockAdapter clockAdapter) {
        this.clockAdapter = clockAdapter;
    }

    /*
     * Update all clock views within clock adapter
     * Param:
     * Returns: void
     * */
    public void updateClockViews() {
        clockAdapter.setTime(clockModel.getTime());
        clockAdapter.notifyDataSetChanged();
    }
}
