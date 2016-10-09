package com.example.countdowntimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import me.cinson.countdowntimer.CountdownTimerView;

public class MainActivity extends AppCompatActivity {

    private CountdownTimerView mTimerView,mTimerViewA,mTimerViewB,mTimerViewC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTimerView = (CountdownTimerView) findViewById(R.id.countdown_timer);
        mTimerViewA = (CountdownTimerView) findViewById(R.id.countdown_timer_a);
        mTimerViewB = (CountdownTimerView) findViewById(R.id.countdown_timer_b);
        mTimerViewC = (CountdownTimerView) findViewById(R.id.countdown_timer_c);

        init();
    }

    private void init() {
        long[] times = {0, 0, 2, 0};
        mTimerView.setTimes(times);
        mTimerView.setOnAlertListener(new CountdownTimerView.OnAlertListener() {
            @Override
            public void onAlert() {
                Toast.makeText(MainActivity.this, "On Timer Alert", Toast.LENGTH_SHORT).show();
            }
        });
        mTimerView.run();

        long[] timesA = {1, 0, 1, 30};
        mTimerViewA.setTimes(timesA);
        mTimerViewA.setOnAlertListener(new CountdownTimerView.OnAlertListener() {
            @Override
            public void onAlert() {
                Toast.makeText(MainActivity.this, "On Timer A Alert", Toast.LENGTH_SHORT).show();
            }
        });
        mTimerViewA.run();

        long[] timesB = {0, 8, 8, 8};
        mTimerViewB.setTimes(timesB);
        mTimerViewB.setOnAlertListener(new CountdownTimerView.OnAlertListener() {
            @Override
            public void onAlert() {
                Toast.makeText(MainActivity.this, "On Timer B Alert", Toast.LENGTH_SHORT).show();
            }
        });
        mTimerViewB.run();

        long[] timesC = {0, 8, 8, 8};
        mTimerViewC.setTimes(timesC);
        mTimerViewC.setOnAlertListener(new CountdownTimerView.OnAlertListener() {
            @Override
            public void onAlert() {
                Toast.makeText(MainActivity.this, "On Timer B Alert", Toast.LENGTH_SHORT).show();
            }
        });
        mTimerViewC.run();
    }
}
