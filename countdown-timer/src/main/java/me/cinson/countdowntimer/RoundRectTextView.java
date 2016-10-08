package me.cinson.countdowntimer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Description :
 * Created by Cinson on 16/10/5.
 * Email：cinsondev@gmail.com
 */
public class RoundRectTextView extends TextView {
    private static final int DEFAULT_RADIUS = 12;
    private final RectF mRect = new RectF();
    private int destBgColor;

    public RoundRectTextView(Context context) {
        super(context);
    }

    public RoundRectTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundRectTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mRect.set(0, 0, getWidth(), getHeight());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(destBgColor);
        canvas.drawRoundRect(mRect, DEFAULT_RADIUS, DEFAULT_RADIUS, paint);

        super.onDraw(canvas);
    }

    @Override
    public void setBackgroundColor(int color) {
        destBgColor = color;
    }
}

