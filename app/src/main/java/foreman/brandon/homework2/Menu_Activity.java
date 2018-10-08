package foreman.brandon.homework2;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import foreman.brandon.homework2.Commands.Command;
import foreman.brandon.homework2.Commands.CommandQueue;
import foreman.brandon.homework2.Commands.CreateClockView;
import foreman.brandon.homework2.Commands.SetClockTime;
import foreman.brandon.homework2.Controllers.ClockController;
import foreman.brandon.homework2.Models.Clock;
import foreman.brandon.homework2.Views.ClockAdapter;

public class Menu_Activity extends AppCompatActivity {

    private Clock clock;
    private ClockController clockController;
    private Runnable r;
    private Handler handler;
    private boolean firstClock = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        // Initialize ClockController
        clockController = new ClockController();
        Calendar initCalendar = new GregorianCalendar();

        // Initialize ClockModel
        clock = new Clock(clockController, initCalendar);
        //Register ClockModel in controller
        clockController.registerClock(clock);

        // Setup ClockView
        ArrayList<Integer> st = new ArrayList<Integer>();
        // setup our adapter for list view, to take in clock views
        ClockAdapter adapter = new ClockAdapter(this, R.layout.menu_activity, st);
        adapter.setDateTime(initCalendar);
        ListView listView = (ListView) findViewById(R.id.listedClocks_listView);
        listView.setAdapter(adapter);

        // Register View in controller
        clockController.registerClockViewListAdapter(adapter);


        // TODO: Add in Command design pattern for changing the time at which the clocks are set to // Done
        // TODO: Make AnalogClockView // Done
        // TODO: Use Calendar when setting Date Time for clock model // Done
        // TODO: Remove unneeded controller passins and clean up code // Sorta Done
        // TODO: Ask about whether Command design pattern views should be in Clock Controller or can exist on the Menu_Activity layer // Fine to do this way
        // TODO: Ask about how to represent views in Android form i.e. Layouts are views but really XML if they don't have their classes defined in code unless through custom means // We just also used custom view classes. Done
        // TODO: Add documentation


    }

    public void changeClockTime(View view) {
        Button bt = (Button)view;
        Calendar oldCalendar = clockController.getClockTime();
        // Must create new calendar so that old calendar since the objects are passed by reference. A deep copy must be done.
        Calendar newCalendar = new GregorianCalendar();
        switch(bt.getId()) {
            case R.id.bt_changeTime:
                newCalendar.set(Calendar.DATE, oldCalendar.get(Calendar.DATE));
                newCalendar.set(Calendar.MONTH, oldCalendar.get(Calendar.MONTH));
                newCalendar.set(Calendar.DAY_OF_MONTH, oldCalendar.get(Calendar.DAY_OF_MONTH));
                newCalendar.set(Calendar.AM_PM, oldCalendar.get(Calendar.AM_PM));
                TextView time = (TextView)findViewById(R.id.tx_time);
                String timeString = time.getText().toString();
                String[] timeSplit = timeString.split(":");
                int hour = Integer.parseInt(timeSplit[0]);
                if(hour > 12) {
                    newCalendar.set(Calendar.AM_PM, 1);
                    hour = hour - 12; // must subtract 12 since calendar is in 12 hour AM and 12 hour PM. We cannot set calendar to hour 23. Instead we set it to hour 11 of PM.
                }
                else {
                    newCalendar.set(Calendar.AM_PM, 0);
                }
                newCalendar.set(Calendar.HOUR, hour);
                newCalendar.set(Calendar.MINUTE, Integer.parseInt(timeSplit[1]));
                newCalendar.set(Calendar.SECOND, Integer.parseInt(timeSplit[2]));
                break;
            case R.id.bt_changeDate:
                newCalendar.set(Calendar.HOUR, oldCalendar.get(Calendar.HOUR));
                newCalendar.set(Calendar.MINUTE, oldCalendar.get(Calendar.MINUTE));
                newCalendar.set(Calendar.SECOND, oldCalendar.get(Calendar.SECOND));
                newCalendar.set(Calendar.AM_PM, oldCalendar.get(Calendar.AM_PM));
                TextView date = (TextView)findViewById(R.id.tx_date);
                String dateString = date.getText().toString();
                String[] dateSplit = dateString.split("/");
                newCalendar.set(Calendar.MONTH, Integer.parseInt(dateSplit[0])-1); // month starts at 0, not 1
                newCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateSplit[1]));
                newCalendar.set(Calendar.YEAR, Integer.parseInt(dateSplit[2]));
                break;
        }

        if(newCalendar != null) {
            Command command = new SetClockTime(clockController, oldCalendar, newCalendar);
            command.doIt();
            CommandQueue.push(command);
        }
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

        if(firstClock) {
            createClockThread();
            firstClock = !firstClock;
        }
    }

    public void undoCommand(View view){
        CommandQueue.undo();
    }

    public void redoCommand(View view) {
        CommandQueue.redo();
    }

        /*
        Note: creating a task as such will run in the background during other activities. This means that this task will run indefinitely unless stopped.
        There is no need to start a new task when switching to a new activity. Tasks are simply started from an activity and are not decedent on the activity once instantiated.
         */
    public void createClockThread() {
        // runnable declaration in order to allow the clock UI to be updated every second and tick the clock
        r = new Runnable() {
            @Override
            public void run() {
                Calendar calendar = clockController.getClockTime();
                calendar.add(Calendar.SECOND, 1);
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE MMMMM yyyy HH:mm:ss", Locale.US);
                Log.d("TIME", dateFormat.format(calendar.getTime()));
                clockController.setClockTime(calendar);

                // create a handler for this runnable task
                handler.postDelayed(r, 1000);
            }
        };

        handler = new Handler();
        // delay the task so that it on;y runs every second
        handler.postDelayed(r, 1000);
    }

}
