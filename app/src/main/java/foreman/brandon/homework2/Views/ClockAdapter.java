package foreman.brandon.homework2.Views;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Calendar;

import foreman.brandon.homework2.R;

import static foreman.brandon.homework2.R.layout.analogclock_row;

public class ClockAdapter extends ArrayAdapter<Integer> {
    private ArrayList<Integer> views;
    private Calendar time;

    public ClockAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ClockAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ClockAdapter(Context context, int resource, ArrayList<Integer> views) {
        // Note to future Brandon, do not touch this constructor. The views arraylist is both the super class arraylist and child class's array list. There is no public getter for the views
        // in superclass. So we must assign the views here also in the child class. If you don't assign in both places, view doesn't display anything.
        super(context, resource, views);
        this.views = views;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // We need to use an inflater to inflate each of our views in our list. Inflating is similar to rendering. The view is inflated from XML to the screen and able to be viewed.
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View clockViewRow = null;
        // digital clock
        if(views.get(position) == 1) {
            // inflate the view
            clockViewRow = layoutInflater.inflate(R.layout.digitalclock_row, parent, false);
            DigitalClockView clockView = (DigitalClockView) clockViewRow.findViewById(R.id.digitalClock_view);
            clockView.setTime(time);
        }
        // analog clock
        else {
            clockViewRow = layoutInflater.inflate(analogclock_row, parent, false);
            AnalogClockView clockView = (AnalogClockView) clockViewRow.findViewById(R.id.analogClock_view);
            clockView.setTime(time);
        }
        return clockViewRow;
    }

    public int addNewView(Integer viewType) {
        views.add(viewType);
        return views.size()-1;
    }

    public void removeView(int position) {
        views.remove(position);
    }

    public void setTime(Calendar calendar) {
        this.time = calendar;
    }

    public int getSize() {
        return views.size();
    }
}
