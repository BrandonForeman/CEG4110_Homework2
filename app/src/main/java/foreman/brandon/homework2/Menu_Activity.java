package foreman.brandon.homework2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu_Activity extends AppCompatActivity {

    private Clock clock;
    private ClockController clockController;
    private TextView timeView;
    Runnable r;
    Handler handler;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        clockController = new ClockController();

        DateTime time = new DateTime(30, 59, 8, "Monday", 2, "January", 1997);
        clock = new Clock(clockController, time);

        timeView = findViewById(R.id.timeView1);
        clockController.registerClock(clock);
        clockController.registerClockView(timeView);
        clockController.registerClockView((TextView)findViewById(R.id.timeView2));
        clockController.registerClockView((TextView)findViewById(R.id.timeView3));
        clockController.registerClockView((TextView)findViewById(R.id.timeView4));
        clockController.registerClockView((TextView)findViewById(R.id.timeView5));

        // runnable declaration in order to allow the clock UI to be updated every second and tick the clock

        /*
        Note: creating a task as such will run in the background during other activities. This means that this task will run indefinitely unless stopped.
        There is no need to start a new task when switching to a new activity. Tasks are simply started from an activity and are not decedent on the activity once instantiated.

         */
        r = new Runnable() {
            @Override
            public void run() {
                DateTime time = clockController.getClockTime();
                int seconds = time.getSecond() + 1;
                int minutes = time.getMinute();
                minutes = (seconds/60 == 1 && seconds != 0) ? minutes+1: minutes;
                int hour = time.getHour();
                hour = (minutes/60 == 1 && minutes != 0) ? hour+1: hour;
                time.setSecond(seconds%60);
                time.setMinute(minutes%60);
                time.setHour(hour%24);
                clockController.setClockTime(time);
                // create a handler for this runnable task
                handler.postDelayed(r, 1000);
            }
        };
//
        handler = new Handler();
        // delay the task so that it on;y runs every second
        handler.postDelayed(r, 1000);
    }

    public void changeTime(View view) {
        Intent intent = new Intent(this, changeTime.class);
        startActivity(intent);
    }

}
