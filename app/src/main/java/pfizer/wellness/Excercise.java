package pfizer.wellness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ROEL on 4/10/2017.
 */

public class Excercise extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iBtnNever)
    ImageButton miBtnNever;

    @BindView(R.id.iBtnRarely)
    ImageButton miBtnRarely;

    @BindView(R.id.iBtnRegularly)
    ImageButton miBtnRegularly;

    @BindView(R.id.nextbuttonexercise)
    Button miBtnNextExcercise;

    int condition = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excercise);
        ButterKnife.bind(this);

        condition = getIntent().getIntExtra("condition", 0);
//      Toast.makeText(this, "hello "+condition, Toast.LENGTH_SHORT).show();

        miBtnNever.setOnClickListener(this);
        miBtnRarely.setOnClickListener(this);
        miBtnRegularly.setOnClickListener(this);
        miBtnNextExcercise.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case  R.id.iBtnNever: {
                Intent myIntent = new Intent(v.getContext(), Diet.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
            case  R.id.iBtnRarely: {
                Intent myIntent = new Intent(v.getContext(), Diet.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
            case  R.id.iBtnRegularly: {
                Intent myIntent = new Intent(v.getContext(), Diet.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
            case  R.id.nextbuttonexercise: {
                Intent myIntent = new Intent(v.getContext(), Diet.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
        }
    }
}
