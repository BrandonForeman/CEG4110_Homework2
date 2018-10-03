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
        super(context, resource, values);
        this.dateTime = dateTime;
    }

    public void RegisterClockController(ClockController clockController) {
        this.clockController = clockController;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // We need to use an inflater to inflate each of our views in our list. Inflating is similar to rendering. The view is inflated from XML to the screen and able to be viewed.
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // digital clock
            // inflate the view
            View clockViewRow = layoutInflater.inflate(R.layout.digitalclock_row, parent, false);
            ClockView clockView = (ClockView) clockViewRow.findViewById(R.id.digitalClock_view);
            clockView.setDateTime(dateTime);
        return clockViewRow;
    }

    public void addNewView(Integer viewType) {
        values.add(viewType);
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getSize() {
        return values.size();
    }
}
