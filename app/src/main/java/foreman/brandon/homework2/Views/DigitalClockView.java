package foreman.brandon.homework2.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import foreman.brandon.homework2.R;

public class DigitalClockView extends RelativeLayout implements IClockView {

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

    public void setTime(Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMM dd, yyyy hh:mm:ss a", Locale.US);
        clockTextView.setText(dateFormat.format(calendar.getTime()));
    }


}
