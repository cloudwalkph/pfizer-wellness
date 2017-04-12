package pfizer.wellness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ROEL on 4/10/2017.
 */

public class BMICalculator extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.nextbutton)
    Button mNextBtn;

    @BindView(R.id.etHeight)
    EditText mHeight;

    @BindView(R.id.etWeight)
    EditText mWeight;

    @BindView(R.id.btnCalculate)
    Button mCalculate;

    @BindView(R.id.tBmiResult)
    TextView mBmiResult;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);
        ButterKnife.bind(this);

        mNextBtn.setOnClickListener(this);
        mCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        float weight = 0;
        float height = 0;
        double result = 0;
        double bmiResult = 0;
        double passResult = 0;
        int condition = 5;
        String rounded;

        if (TextUtils.isEmpty(mWeight.getText().toString())
                || TextUtils.isEmpty(mHeight.getText().toString())) {
            return;
        }

        switch (v.getId()) {
            case  R.id.nextbutton: {
                rounded = mBmiResult.getText().toString();
                passResult = Double.parseDouble(rounded);

                if( passResult < 18.5 ){
                    condition = 1;
                }

                if( passResult >= 18.5 && passResult <= 24.9 ){
                    condition = 2;
                }

                if( passResult > 24.9 && passResult <= 29.9  ){
                    condition = 3;
                }

                if( passResult > 29.9 && passResult <= 34.9 ){
                    condition = 4;
                }

                if( passResult >= 40 ){
                    condition = 5;
                }

//                Toast.makeText(this, "asd "+condition, Toast.LENGTH_SHORT).show();

                Intent myIntent = new Intent(v.getContext(), Sleep.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);

                break;
            }

            case  R.id.btnCalculate: {

                weight = Float.parseFloat( mWeight.getText().toString() );
                height = Float.parseFloat( mHeight.getText().toString() );

                result = weight / ( ( height * 0.01 ) * ( height * 0.01 ) );
                rounded = String.format("%.2f", result);

                mBmiResult.setText( rounded );

                break;

            }
        }

    }
}
