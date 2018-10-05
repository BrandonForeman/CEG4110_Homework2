package foreman.brandon.homework2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ClockAdapter extends ArrayAdapter<Integer> {
    private ClockController clockController;
    private ArrayList<Integer> values;
    //    private String[] values;
    private DateTime dateTime;

    public ClockAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ClockAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ClockAdapter(Context context, int resource, ArrayList<Integer> values, DateTime dateTime) {
        // Note to future Brandon, do not touch this constructor. The values arraylist is both the super class arraylist and child class's array list. There is no public getter for the values
        // in superclass. So we must assign the values here also in the child class. If you don't assign in both places, view doesn't display anything.
        super(context, resource, values);
        this.values = values;
        this.dateTime = dateTime;
    }

    public void RegisterClockController(ClockController clockController) {
        this.clockController = clockController;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // We need to use an inflater to inflate each of our views in our list. Inflating is similar to rendering. The view is inflated from XML to the screen and able to be viewed.
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View clockViewRow = null;
        // digital clock
        if(values.get(position) == 1) {
            // inflate the view
            clockViewRow = layoutInflater.inflate(R.layout.digitalclock_row, parent, false);
            ClockView clockView = (ClockView) clockViewRow.findViewById(R.id.digitalClock_view);
            clockView.setDateTime(dateTime);
        }
        // analog clock
        else {

        }
        return clockViewRow;
    }

    public int addNewView(Integer viewType) {
        values.add(viewType);
        return values.size()-1;
    }

    public void removeView(int position) {
        values.remove(position);
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getSize() {
        return values.size();
    }
}
