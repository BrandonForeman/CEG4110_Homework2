package foreman.brandon.homework2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class DigitalClockView extends ClockView {

    private View rootView;
    private TextView clockTextView;

    public DigitalClockView(Context context) {
        super(context);
        init(context);
    }

    public DigitalClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        rootView = inflate(context, R.layout.digitalclock_view, this);
        clockTextView = (TextView)rootView.findViewById(R.id.timeText);
    }

    public void setDateTime(DateTime dateTime) {
        clockTextView.setText(dateTime.toString());
    }


}
