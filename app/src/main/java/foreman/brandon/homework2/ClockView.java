package foreman.brandon.homework2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class ClockView extends RelativeLayout {
    private ClockController clockController;
    private DateTime dateTime;


    public ClockView(Context context) {
        super(context);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public DateTime getDateTime() {
        return this.dateTime;
    }
}
