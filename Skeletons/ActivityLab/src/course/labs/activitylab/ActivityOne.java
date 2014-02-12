package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    // String for LogCat documentation
    private final static String TAG = "Lab-ActivityOne";

    // Lifecycle counters
    private Integer mCreate = 0;
    private Integer mStart = 0;
    private Integer mResume = 0;
    private Integer mRestart = 0;
    private TextView mTvCreate;
    private TextView mTvStart;
    private TextView mTvResume;
    private TextView mTvRestart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        // TODO: Assign the appropriate TextViews to the TextView variables

        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvResume = (TextView) findViewById(R.id.resume);
        mTvStart = (TextView) findViewById(R.id.start);


        Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
        launchActivityTwoButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO:
                Intent intent = new Intent(getApplicationContext(), ActivityTwo.class);
                startActivity(intent);

            }
        });

        // Check for previously saved state
        if (savedInstanceState != null) {
            // TODO:
            mCreate = savedInstanceState.getInt(CREATE_KEY);
            mStart = savedInstanceState.getInt(START_KEY);
            mRestart = savedInstanceState.getInt(RESTART_KEY);
            mResume = savedInstanceState.getInt(RESUME_KEY);
        }

        // TODO: Emit LogCat message
        Log.i(TAG, "Entered the OnCreate() method");

        // TODO:
        mCreate++;
        displayCounts();


    }

    // Lifecycle callback overrides

    @Override
    public void onStart() {
        super.onStart();

        // TODO: Emit LogCat message
        Log.i(TAG, "Entered the OnStart() method");

        // TODO:
        mStart++;
        displayCounts();


    }

    @Override
    public void onResume() {
        super.onResume();

        // TODO: Emit LogCat message
        Log.i(TAG, "Entered the OnResume method");

        // TODO:
        mResume++;
        displayCounts();


    }

    @Override
    public void onPause() {
        super.onPause();

        // TODO: Emit LogCat message
        Log.i(TAG, "Entered the OnPause() method");

    }

    @Override
    public void onStop() {
        super.onStop();

        // TODO: Emit LogCat message
        Log.i(TAG, "Entered the OnStop method");

    }

    @Override
    public void onRestart() {
        super.onRestart();

        // TODO: Emit LogCat message
        Log.i(TAG, "Entered the OnRestart() method");

        // TODO:
        mRestart++;
        displayCounts();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // TODO: Emit LogCat message
        Log.i(TAG, "Entered the OnDestroy() method");

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // TODO:
        mCreate = savedInstanceState.getInt(CREATE_KEY);
        mStart = savedInstanceState.getInt(START_KEY);
        mResume = savedInstanceState.getInt(RESUME_KEY);
        mRestart = savedInstanceState.getInt(RESTART_KEY);
    }

    // Updates the displayed counters
    public void displayCounts() {

        mTvCreate.setText("onCreate() calls: " + mCreate);
        mTvStart.setText("onStart() calls: " + mStart);
        mTvResume.setText("onResume() calls: " + mResume);
        mTvRestart.setText("onRestart() calls: " + mRestart);

    }
}
