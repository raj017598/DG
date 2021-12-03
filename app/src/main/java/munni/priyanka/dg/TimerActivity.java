package munni.priyanka.dg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button StartButton, StopButton;
    private TextView textView;
    private Handler handler;

    long start = 0L;
    long update = 0L;
    long swapTime = 0L;
    long millisecond = 0L;
    long delay = 0L;

    boolean timerStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#232D36"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle("Timer");


        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
        boolean first = sharedPreferences.getBoolean("firstTimer",true);
        if(first)
            showdialogOnStart();

        StartButton = (Button)findViewById(R.id.btnStart);
        StopButton = (Button)findViewById(R.id.btnStop);
        textView = (TextView)findViewById(R.id.textView);

        handler = new Handler();

        StartButton.setOnClickListener(this);
        StopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id)
        {
            case R.id.btnStart :
            {
                if(timerStarted)
                {
                    StartButton.setText("Start");
                    swapTime += millisecond;
                    handler.removeCallbacks(time);
                    timerStarted = !timerStarted;
                }
                else
                {
                    StartButton.setText("Pause");
                    start = SystemClock.uptimeMillis();
                    handler.postDelayed(time, delay);
                    timerStarted = !timerStarted;
                }
                break;
            }
            case R.id.btnStop:
            {
                start = 0L;
                update = 0L;
                swapTime = 0L;
                millisecond = 0L;

                timerStarted = false;

                StartButton.setText("Start");
                textView.setText("00:00:00");
                handler.removeCallbacks(time);
                break;
            }
            default:
            {
                break;
            }
        }
    }

    Runnable time = new Runnable() {
        @Override
        public void run() {

            millisecond = SystemClock.uptimeMillis() - start;
            update = swapTime + millisecond;
            int seconds = (int) (update/100);
            int minutes = seconds/60;
            seconds = seconds%60;
            int milliseconds = (int) (millisecond%100);
            String str = String.format("%02d",minutes)+":"+String.format("%02d",seconds)+":"+String.format("%02d",milliseconds);
            textView.setText(str);
            handler.postDelayed(this,delay);

        }
    };

    public  void showdialogOnStart()
    {
        new AlertDialog.Builder(TimerActivity.this).setTitle("Welcome !")
                .setMessage("Scientific Calculator is designed by SUBHAM KUMAR.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("firstTimer",false);
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
    }
}