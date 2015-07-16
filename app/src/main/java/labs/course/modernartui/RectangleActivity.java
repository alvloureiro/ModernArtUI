package labs.course.modernartui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loureiro on 7/16/15.
 */
public class RectangleActivity extends View {
    private int mX = 0;

    private int mY = 0;

    private int mWidth = 700;

    private int mHeight = 700;

    private static final int MAX_RECTANGLES = 5;

    private static int mCount = 0;

    private List<Rect> mRectangles = new ArrayList<Rect>();

    private Paint mPaint = new Paint();

    public RectangleActivity(Context context) {
        super(context);
        Rect rect;
        for (mCount = 0; mCount < MAX_RECTANGLES; mCount++) {
            rect = new Rect(mX, mY, mWidth, mHeight);
            mRectangles.add(rect);
        }

        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
