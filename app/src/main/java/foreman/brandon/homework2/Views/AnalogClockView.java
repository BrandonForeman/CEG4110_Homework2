package foreman.brandon.homework2.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tomerrosenfeld.customanalogclockview.CustomAnalogClock;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import foreman.brandon.homework2.R;

public class AnalogClockView extends RelativeLayout implements IClockView {
    private View rootView;
    private CustomAnalogClock clock;
    private TextView date;
    public AnalogClockView(Context context) {
        super(context);
        init(context);
    }

    public AnalogClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        rootView = inflate(context, R.layout.analogclock_view, this);
         date = (TextView)rootView.findViewById(R.id.tx_analogDate);
         clock = (CustomAnalogClock)rootView.findViewById(R.id.analog_clock);
         clock.init(context, R.drawable.default_face, R.drawable.default_hour_hand, R.drawable.default_minute_hand, 0, false, false);
    }

    @Override
    public void setTime(Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, YYYY, ss a");
        date.setText(dateFormat.format(calendar.getTime()));
        clock.setTime(calendar);
    }

}
