package com.example.countdowntimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import me.cinson.countdowntimer.CountdownTimerView;

public class MainActivity extends AppCompatActivity {

    private CountdownTimerView mTimerView1,mTimerView2,mTimerView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTimerView1 = (CountdownTimerView) findViewById(R.id.countdown_timer_1);
        mTimerView2 = (CountdownTimerView) findViewById(R.id.countdown_timer_2);
        mTimerView3 = (CountdownTimerView) findViewById(R.id.countdown_timer_3);

        init();
    }

    private void init() {
        long[] times1 = {0, 0, 1, 30};
        mTimerView1.setTimes(times1);
        mTimerView1.setOnAlertListener(new CountdownTimerView.OnAlertListener() {
            @Override
            public void onAlert() {
                Toast.makeText(MainActivity.this, "On Timer 1 Alert", Toast.LENGTH_SHORT).show();
            }
        });
        mTimerView1.run();

        long[] times2 = {1, 0, 1, 30};
        mTimerView2.setTimes(times2);
        mTimerView2.setOnAlertListener(new CountdownTimerView.OnAlertListener() {
            @Override
            public void onAlert() {
                Toast.makeText(MainActivity.this, "On Timer 2 Alert", Toast.LENGTH_SHORT).show();
            }
        });
        mTimerView2.run();

        long[] times3 = {0, 8, 8, 8};
        mTimerView3.setTimes(times3);
        mTimerView3.setOnAlertListener(new CountdownTimerView.OnAlertListener() {
            @Override
            public void onAlert() {
                Toast.makeText(MainActivity.this, "On Timer 3 Alert", Toast.LENGTH_SHORT).show();
            }
        });
        mTimerView3.run();
    }
}
