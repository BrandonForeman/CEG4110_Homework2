package foreman.brandon.homework2;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Menu_Activity extends AppCompatActivity {

    private Clock clock;
    private ClockController clockController;
    private Runnable r;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        clockController = new ClockController();

        DateTime time = new DateTime(30, 59, 8, "Monday", 2, "January", 1997);
        clock = new Clock(clockController, time);

        // get current activity context through "Menu_Activity.this"
        clockController.registerClock(clock);

        ArrayList<Integer> st = new ArrayList<Integer>();
        st.add(1);
        // setup our adapter for list view, to take in clock views
        ClockAdapter adapter = new ClockAdapter(this, R.layout.menu_activity, st, time);
//        adapter.setDateTime(time);
        ListView listView = (ListView) findViewById(R.id.listedClocks_listView);
        listView.setAdapter(adapter);

        clockController.registerClockViewListAdapter(adapter);
//        for(int i = 0; i< 20; i++) {
//            clockController.addClockView(1);
//        }


        // TODO: Add in Command design pattern for changing the time at which the clocks are set to
        // TODO: Make AnalogClockView
        // TODO: Use Calendar when setting DateTime for clock model
        // TODO: Remove unneeded controller passins
        // TODO: Ask about whether Command design pattern views should be in Clock Controller or can exist on the Menu_Activity layer


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
                Log.d("TIME", time.toString());
                clockController.setClockTime(time);

                // create a handler for this runnable task
                handler.postDelayed(r, 1000);
            }
        };

        handler = new Handler();
        // delay the task so that it on;y runs every second
        handler.postDelayed(r, 1000);
    }

    public void changeClockTime(View view) {

    }

    public void addClock(View view){
        Button bt = (Button)view;
        Command command = null;
        switch(bt.getId()) {
            case R.id.bt_add_digitalClock:
                // add digital clock
                command = new CreateClockView(clockController, 1);
                break;
            case R.id.bt_add_analogClock:
                // add analog clock
                command = new CreateClockView(clockController, 2);
                break;
        }
        if(command != null) {
            command.doIt();
            CommandQueue.push(command);
        }
    }

    public void undoCommand(View view){
        CommandQueue.undo();
    }

    public void redoCommand(View view) {
        CommandQueue.redo();
    }

}
