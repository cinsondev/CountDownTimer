# CountDownTimer
A simple countdown timer view

To be added

## Usage

Step 1. add the CountdownTimerView to your layout file.


    <me.cinson.countdowntimer.CountdownTimerView
        android:id="@+id/countdown_timer"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />


Step 2. set times to the CountdownTimerView and run it.

        mTimerView = (CountdownTimerView) findViewById(R.id.countdown_timer);
        ...
        ...
        long[] times = {0, 0, 1, 30};
        mTimerView.setTimes(times);
        mTimerView1.run();

## Customization the style

To be added

## countdown Alert

To be added



