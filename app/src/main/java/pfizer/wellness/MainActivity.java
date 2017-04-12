package pfizer.wellness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_begin)
    Button mBtnBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBtnBegin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btn_begin: {
                Intent myIntent = new Intent(v.getContext(), CustomerDetails.class);
                startActivityForResult(myIntent, 0);
                break;
            }

//            case R.id.clickButton2: {
//                // do something for button 2 click
//                break;
//            }

        }
    }
}
