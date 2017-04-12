package pfizer.wellness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ROEL on 4/10/2017.
 */

public class WorkRoutine extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iBtnActive)
    ImageButton mIBtnActive;

    @BindView(R.id.iBtnInActive)
    ImageButton mIBtnInActive;

    @BindView(R.id.nBtnWorkRoutine)
    Button mnBtnWorkRoutine;

    int condition = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work_routine);

        ButterKnife.bind(this);

        condition = getIntent().getIntExtra("condition", 0);
//        Toast.makeText(this, "hello "+condition, Toast.LENGTH_SHORT).show();

        mIBtnActive.setOnClickListener(this);
        mIBtnInActive.setOnClickListener(this);
        mnBtnWorkRoutine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.iBtnActive: {
                Intent myIntent = new Intent(v.getContext(), ResultGreat.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
            case  R.id.iBtnInActive: {
                Intent myIntent = new Intent(v.getContext(), ResultGreat.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
//            case  R.id.nBtnWorkRoutine: {
//                Intent myIntent = new Intent(v.getContext(), WorkRoutine.class);
//                startActivityForResult(myIntent, 0);
//                break;
//            }
        }
    }
}
