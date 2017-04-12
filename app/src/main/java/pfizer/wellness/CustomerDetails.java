package pfizer.wellness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ROEL on 4/9/2017.
 */

public class CustomerDetails extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_submit)
    Button mBtnSubmit;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_details);
        ButterKnife.bind(this);

        Spinner spinnerMonth = (Spinner) findViewById(R.id.spinnerMonth);
        Spinner spinnerDay = (Spinner) findViewById(R.id.spinnerDay);
        Spinner spinnerYear = (Spinner) findViewById(R.id.spinnerYear);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerYesNo);

        /*Date*/
        /*Month*/
        ArrayAdapter<CharSequence> adapterMonth = ArrayAdapter.createFromResource(this,
                R.array.array_month, R.layout.spinner_item);
        adapterMonth.setDropDownViewResource(R.layout.spinner_dropdown);
        spinnerMonth.setAdapter(adapterMonth);

        /*Day*/
        ArrayAdapter<CharSequence> adapterDay = ArrayAdapter.createFromResource(this,
                R.array.array_day, R.layout.spinner_item);
        adapterDay.setDropDownViewResource(R.layout.spinner_dropdown);
        spinnerDay.setAdapter(adapterDay);

        /*Year*/
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(this, R.layout.spinner_item, years);
        adapterYear.setDropDownViewResource(R.layout.spinner_dropdown);
        spinnerYear.setAdapter(adapterYear);

        /*Radio Yes and No*/
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.yes_no, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);

        mBtnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btn_submit: {
                Intent myIntent = new Intent(v.getContext(), Welcome.class);
                startActivityForResult(myIntent, 0);
                break;
            }
        }
    }
}
