package foreman.brandon.homework2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import java.util.Calendar;

import foreman.brandon.homework2.ClockController;
import foreman.brandon.homework2.DateTime;

public abstract class ClockView extends RelativeLayout {
    private ClockController clockController;
    private Calendar calendar;


    public ClockView(Context context) {
        super(context);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
