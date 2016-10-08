package me.cinson.countdowntimer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Description :
 * Created by Cinson on 16/10/5.
 * Email：cinsondev@gmail.com
 */
public class CountdownTimerView extends LinearLayout implements Runnable {
    private static final int DEFAULT_TEXT_COLOR = Color.BLACK;
    private static final int DEFAULT_BG_COLOR = Color.TRANSPARENT;
    private static final int DEFAULT_TEXT_SIZE = 14;
    private static final int DEFAULT_TEXT_PADDING = 2;
    private long mDay, mHour, mMin, mSecond;
    private boolean isRun = false;
    private OnAlertListener alertListener;

    private RoundRectTextView tvDay, tvHour, tvMin, tvSec;
    private TextView tvDaySuffix, tvHourSuffix, tvMinSuffix;

    public CountdownTimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CountdownTimerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_countdown_timer, this);

        tvDay = (RoundRectTextView) view.findViewById(R.id.tv_day);
        tvHour = (RoundRectTextView) view.findViewById(R.id.tv_hour);
        tvMin = (RoundRectTextView) view.findViewById(R.id.tv_min);
        tvSec = (RoundRectTextView) view.findViewById(R.id.tv_sec);

        tvDaySuffix = (TextView) view.findViewById(R.id.tv_day_suffix);
        tvHourSuffix = (TextView) view.findViewById(R.id.tv_hour_suffix);
        tvMinSuffix = (TextView) view.findViewById(R.id.tv_min_suffix);


        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.countdownTimer);
        int bgColor = array.getColor(R.styleable.countdownTimer_backgroundColor, DEFAULT_BG_COLOR);
        int textColor = array.getColor(R.styleable.countdownTimer_textColor, DEFAULT_TEXT_COLOR);
        float textSize = array.getDimension(R.styleable.countdownTimer_textSize, -1);
        int textPadding = (int) array.getDimension(R.styleable.countdownTimer_textPadding, DEFAULT_TEXT_PADDING);

        customize(bgColor, textColor, textSize, textPadding);
        array.recycle();
    }

    private void customize(int bgColor, int textColor, float textSize, int textPadding) {
        tvDay.setBackgroundColor(bgColor);
        tvHour.setBackgroundColor(bgColor);
        tvMin.setBackgroundColor(bgColor);
        tvSec.setBackgroundColor(bgColor);

        tvDay.setTextColor(textColor);
        tvHour.setTextColor(textColor);
        tvMin.setTextColor(textColor);
        tvSec.setTextColor(textColor);

        int destTextColor;
        if (bgColor == DEFAULT_BG_COLOR) {
            destTextColor = textColor;
        } else {
            destTextColor = bgColor;
        }
        tvDaySuffix.setTextColor(destTextColor);
        tvHourSuffix.setTextColor(destTextColor);
        tvMinSuffix.setTextColor(destTextColor);


        int sizeUnit = TypedValue.COMPLEX_UNIT_PX;
        if (textSize < 0) {
            textSize = DEFAULT_TEXT_SIZE;
            sizeUnit = TypedValue.COMPLEX_UNIT_SP;
        }

        tvDay.setTextSize(sizeUnit, textSize);
        tvDaySuffix.setTextSize(sizeUnit, textSize);
        tvHour.setTextSize(sizeUnit, textSize);
        tvHourSuffix.setTextSize(sizeUnit, textSize);
        tvMin.setTextSize(sizeUnit, textSize);
        tvMinSuffix.setTextSize(sizeUnit, textSize);
        tvSec.setTextSize(sizeUnit, textSize);

        tvDay.setPadding(textPadding, textPadding, textPadding, textPadding);
        tvDaySuffix.setPadding(textPadding, textPadding, textPadding, textPadding);
        tvHour.setPadding(textPadding, textPadding, textPadding, textPadding);
        tvHourSuffix.setPadding(textPadding, textPadding, textPadding, textPadding);
        tvMin.setPadding(textPadding, textPadding, textPadding, textPadding);
        tvMinSuffix.setPadding(textPadding, textPadding, textPadding, textPadding);
        tvSec.setPadding(textPadding, textPadding, textPadding, textPadding);
    }

    private void updateView() {

        if (mDay > 0) {
            tvDay.setText(mDay + "");
            tvDay.setVisibility(VISIBLE);
            tvDaySuffix.setVisibility(VISIBLE);
        } else {

        }
        if (mDay <= 0) {
            tvDay.setVisibility(GONE);
            tvDaySuffix.setVisibility(GONE);
        } else if (mDay < 10) {
            tvDay.setText("0" + mDay);
            tvDay.setVisibility(VISIBLE);
            tvDaySuffix.setVisibility(VISIBLE);
        } else {
            tvDay.setText(mDay + "");
            tvDay.setVisibility(VISIBLE);
            tvDaySuffix.setVisibility(VISIBLE);
        }
        if (mHour < 10) {
            tvHour.setText("0" + mHour);
        } else {
            tvHour.setText(mHour + "");
        }

        if (mMin < 10) {
            tvMin.setText("0" + mMin);
        } else {
            tvMin.setText(mMin + "");
        }

        if (mSecond < 10) {
            tvSec.setText("0" + mSecond);
        } else {
            tvSec.setText(mSecond + "");
        }
    }

    public void setTimes(long[] times) {
        mDay = times[0];
        mHour = times[1];
        mMin = times[2];
        mSecond = times[3];
    }

    /**
     * 倒计时计算
     */
    private boolean ComputeTime() {
        boolean countZero = false;
        mSecond--;
        if (mSecond < 0) {
            mMin--;
            mSecond = 59;
            if (mMin < 0) {
                mMin = 59;
                mHour--;
                if (mHour < 0) {
                    mHour = 59;
                    mDay--;
                }
            }
        }

        if (mDay + mHour + mMin + mSecond <= 0) {
            countZero = true;
        }
        return countZero;
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        this.isRun = run;
    }

    @Override
    public void run() {
        isRun = true;
        boolean needAlert = ComputeTime();
        updateView();

        if (needAlert) {
            alertListener.onAlert();
        } else {
            postDelayed(this, 1000);
        }
    }

    public interface OnAlertListener {
        void onAlert();
    }

    public void setOnAlertListener(OnAlertListener listener) {
        this.alertListener = listener;
    }

}

