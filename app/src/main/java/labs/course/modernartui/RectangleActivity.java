package labs.course.modernartui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loureiro on 7/16/15.
 */
public class RectangleActivity extends View {
    private static final String TAG = RectangleActivity.class.getSimpleName();

    private int mId = 0;

    private int mWidth = 0;

    private int mHeight = 0;

    private int mColor = 0;

    private Paint mPaint = new Paint();

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RectangleActivity, 0, 0);
        try {
            mId = typedArray.getResourceId(R.styleable.RectangleActivity_rectangle_id, 0);
            mWidth = typedArray.getResourceId(R.styleable.RectangleActivity_rectangle_width, 0);
            mHeight = typedArray.getResourceId(R.styleable.RectangleActivity_rectangle_height, 0);
            mColor = typedArray.getResourceId(R.styleable.RectangleActivity_rectangle_color, 0);
        }catch (RuntimeException e){
            e.getStackTrace().toString();
        }finally {
            typedArray.recycle();
        }
    }

    public RectangleActivity(Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public RectangleActivity(Context context, AttributeSet attrs, int defStyleAttr) {
        init(context, attrs);
        super(context, attrs, defStyleAttr);

    }

    private Point getLeftCoordinates() {

        Point displaySize = new Point(0, 0);
        getDisplay().getSize(displaySize);
        Log.d(TAG, "-------- display size: " + displaySize.toString());
        Log.d(TAG, "-------- display.x: " + displaySize.x);
        Log.d(TAG, "-------- display.y: " + displaySize.y);

        Point leftPoint = new Point();
        /*if (mX == 0) {
            leftPoint.set(mX, mY);
        } else {
            mX = mX + mMinimumWidth;
            if (mX >= mMaximumWidth) {

            }
        }*/
        return leftPoint;
    }

    private Point getRightCoordinates() {
        return new Point();
    }

    private Rect generateRectangle() {
        Rect rect = new Rect();

        return rect;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*mMaximumHeight = getMeasuredHeight();
        mMaximumWidth = getMeasuredWidth();*/

        /*mPaint.setColor(mColors[0]);
        mPaint.setStrokeWidth(1);
        mRightX += mMinimumWidth;
        mRightY += mMinimumHeight;

        canvas.drawRect(mX, mY, mRightX, mRightY, mPaint);*/

        /*mPaint.setColor(mColors[1]);
        mX = mWidth;
        mRightX += mWidth;
        mRightY += mHeight;
        canvas.drawRect(mX, mY, mRightX, mRightY, mPaint);*/
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(mColor);

        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
    }
}
