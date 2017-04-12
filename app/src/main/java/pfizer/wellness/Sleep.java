package pfizer.wellness;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ROEL on 4/10/2017.
 */

public class Sleep extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.nextbuttonsleep)
    Button mNextBtnSleep;

    @BindView(R.id.etSleep)
    TextView mSleep;

    @BindView(R.id.etWake)
    TextView mWake;

    @BindView(R.id.tvSleepingTime)
    TextView mtvSleepingTime;

    int condition = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep);
        ButterKnife.bind(this);

        condition = getIntent().getIntExtra("condition", 0);

        mNextBtnSleep.setOnClickListener(this);
        mSleep.setOnClickListener(this);
        mWake.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);

        TimePickerDialog mTimePicker;

        switch (v.getId()) {
            case  R.id.nextbuttonsleep: {
                Intent myIntent = new Intent(v.getContext(), Excercise.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
            case R.id.etSleep: {
                mTimePicker = new TimePickerDialog(Sleep.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        mSleep.setText( selectedHour + ":" + selectedMinute);

                    }
                }, hour, minute, true);
                    mTimePicker.setTitle("Select Time");
                    mTimePicker.show();
                break;
            }
            case R.id.etWake: {
                mTimePicker = new TimePickerDialog(Sleep.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        mWake.setText( selectedHour + ":" + selectedMinute);
                        sleepingtime();
                    }
                }, hour, minute, true);
                    mTimePicker.setTitle("Select Time");
                    mTimePicker.show();
                break;
            }
        }
    }

    public void sleepingtime(){
        String startTime = mSleep.getText().toString();
        String endTime = mWake.getText().toString();

        if ( startTime == "00:00" || endTime =="00:00" ){
            return;
        }

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date time1 = null;
        Date time2 = null;

        try{
            time1 = format.parse(startTime);
            time2 = format.parse(endTime);

            long diff = time1.getTime() - time2.getTime();
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;


            String hourResult = Long.toString(diffHours);
            String minutesResult = Long.toString(diffMinutes);
            mtvSleepingTime.setText(hourResult+":"+minutesResult+" hrs");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
