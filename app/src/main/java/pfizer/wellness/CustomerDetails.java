package pfizer.wellness;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pfizer.wellness.handler.DatabaseHandler;
import pfizer.wellness.models.Customer;

import static android.content.ContentValues.TAG;

/**
 * Created by ROEL on 4/9/2017.
 */

public class CustomerDetails extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_submit)
    Button mBtnSubmit;

    @BindView(R.id.btn_export)
    Button mExport;

    @BindView(R.id.textCustomerName)
    EditText mCustomerName;

    @BindView(R.id.radioGender)
    RadioGroup mRadioGender;

    private RadioButton radioButton;

    @BindView(R.id.radioMale)
    RadioButton mRadioMale;

    @BindView(R.id.radioFemale)
    RadioButton mRadioFemaie;

    @BindView(R.id.spinnerMonth)
    Spinner mSpinnerMonth;

    @BindView(R.id.spinnerDay)
    Spinner mSpinnerDay;

    @BindView(R.id.spinnerYear)
    Spinner mSpinnerYear;

    @BindView(R.id.spinnerYesNo)
    Spinner mSpinnerYesNo;

    @BindView(R.id.radioNone)
    RadioButton mRadioNone;

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

        int checkid = 0;

        String customer_name = mCustomerName.getText().toString();

        // Gender
        // get selected radio button from radioGroup
        int selectedId = mRadioGender.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);
        String gender= radioButton.getText().toString();

        // Date
        String date = mSpinnerYear.getSelectedItem().toString() + "-" +
                mSpinnerMonth.getSelectedItem().toString() + "-" +
                mSpinnerDay.getSelectedItem().toString();

        // Condition
        String condition = mSpinnerYesNo.getSelectedItem().toString();

        switch (v.getId()) {
            case  R.id.btn_export: {

            }
            case  R.id.btn_submit: {

                DatabaseHandler db = new DatabaseHandler(this);

                /**
                 * Crud Operations
                **/

                // Inserting Customers
                Log.d("Insert : ", "Inserting ..");
                db.addCustomer( new Customer( customer_name, gender, date, condition ));

                // Reading all contacts
                Log.d("Reading: ", "Reading all contacts..");
                List<Customer> customers = db.getAllCustomers();

                for (Customer cd : customers) {
//                    String log = "Id: " +
//                            cd.getID() +
//                            "Id: " + cd.getID() +
//                            " ,Uuid: " + cd.getUID() +
//                            " ,Name: " + cd.getName() +
//                            " ,Gender: " + cd.getGender() +
//                            " ,Birth Date: " + cd.getDateOfBirth() +
//                            " ,Condition: " + cd.getPreExistingConditions();

                    checkid = cd.getID();
                }

                if ( checkid > 0 ){

                    Intent myIntent = new Intent(v.getContext(), Welcome.class);
                    startActivityForResult(myIntent, 0);

                }else{

                    Log.e("Developer : ", "Failed to save");
                    Toast.makeText(this, "Developer : Failed to save", Toast.LENGTH_LONG);

                }

                break;
            }
        }
    }
}
