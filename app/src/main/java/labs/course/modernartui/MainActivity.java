package labs.course.modernartui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DialogFragment mDialogFragment = null;
    int count = 0;
    private int[] mColors =  {Color.MAGENTA, Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.BLACK, Color.CYAN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.modern_layout);

        int width = (int) getResources().getDimension(R.dimen.image_width);
        int height = (int) getResources().getDimension(R.dimen.image_height);
        Point displaySize = new Point ();
        getWindowManager ().getDefaultDisplay ().getSize (displaySize);
        int displayWidth = displaySize.x;

        // Get container View
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.main_view);
        LinearLayout linearLayout = (LinearLayout) findViewById (R.id.container_1);

        // Create Cyan Shape
        final ShapeDrawable cyanShape = new ShapeDrawable (new RectShape ());
        cyanShape.getPaint().setColor (Color.CYAN);
        cyanShape.setIntrinsicHeight (height);
        cyanShape.setIntrinsicWidth (displayWidth - width);

        final ImageView cyanView = new ImageView (getApplicationContext());
        cyanView.setImageDrawable (cyanShape);
        linearLayout.addView (cyanView);

        // Create Magenta Shape
        final ShapeDrawable magentaShape = new ShapeDrawable(new RectShape ());
        magentaShape.getPaint().setColor (Color.MAGENTA);
        magentaShape.setIntrinsicHeight (height);

        magentaShape.setIntrinsicWidth (displayWidth - width);

        // Put Magenta Shape into an ImageView
        final ImageView magentaView = new ImageView(getApplicationContext());
        magentaView.setImageDrawable (magentaShape);

        linearLayout.addView (magentaView);

        // Create the yellow shape
        final ShapeDrawable yellowShape = new ShapeDrawable (new RectShape ());
        yellowShape.getPaint ().setColor (Color.YELLOW);;
        yellowShape.setIntrinsicHeight (height);
        Log.d (TAG, "displayWidth - width: " + (displayWidth - width));
        yellowShape.setIntrinsicWidth (displayWidth - width - 38);

        final ImageView yellowView = new ImageView (getApplicationContext ());
        yellowView.setImageDrawable (yellowShape);

        linearLayout.addView (yellowView);

        LinearLayout linearLayout1 = (LinearLayout)findViewById (R.id.container_2);

        final ShapeDrawable redShape = new ShapeDrawable (new RectShape ());
        redShape.getPaint ().setColor (Color.RED);
        redShape.setIntrinsicHeight (height);
        Log.d (TAG, "displayWidth - width: " + (displayWidth - width));
        redShape.setIntrinsicWidth (displayWidth - width);

        final ImageView redView = new ImageView (getApplicationContext ());
        redView.setImageDrawable (redShape);

        linearLayout1.addView (redView);

        final ShapeDrawable greenShape = new ShapeDrawable (new RectShape ());
        greenShape.getPaint ().setColor (Color.GREEN);

        greenShape.setIntrinsicHeight (height);
        greenShape.setIntrinsicWidth (width);

        final ImageView greenView = new ImageView (getApplicationContext ());
        greenView.setImageDrawable (greenShape);

        linearLayout1.addView (greenView);

        SeekBar colorbar = (SeekBar)findViewById(R.id.color_seekbar);
        colorbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d (TAG, "SeekBar progress: " + progress);
                magentaShape.getPaint ().setColor (getRandomColor ());
                cyanShape.getPaint ().setColor (getRandomColor ());
                yellowShape.getPaint ().setColor (getRandomColor ());
                redShape.getPaint ().setColor (getRandomColor ());
                greenShape.getPaint ().setColor (getRandomColor ());
                magentaView.invalidate ();
                cyanView.invalidate ();
                yellowView.invalidate ();
                redView.invalidate();
                greenView.invalidate ();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_more_information) {
            Log.d(TAG, "More Information clicked");
            showDialogFragment();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showDialogFragment() {
        mDialogFragment = MoreInformationDialogFragment.newInstance();
        mDialogFragment.show(getFragmentManager(), "More Information");
    }

    private int getRandomColor() {
        if (count >= mColors.length - 1)
            count = 0;
        else
            count++;
        Log.d (TAG, "Color count: " + count);
        return mColors[count];
    }
}
