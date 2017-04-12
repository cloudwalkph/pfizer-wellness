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

public class Diet extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iBtnJunk)
    ImageButton mIBtnJunk;

    @BindView(R.id.iBtnBalanced)
    ImageButton mIBtnBalanced;

    @BindView(R.id.iBtnFFG)
    ImageButton mIBtnFFG;

    @BindView(R.id.iBtnVegetarian)
    ImageButton mIBtnVegetarian;

    @BindView(R.id.nBtnDiet)
    Button mNBtnDiet;
    int condition = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet);
        ButterKnife.bind(this);

        condition = getIntent().getIntExtra("condition", 0);

        mIBtnJunk.setOnClickListener(this);
        mIBtnBalanced.setOnClickListener(this);
        mIBtnFFG.setOnClickListener(this);
        mIBtnVegetarian.setOnClickListener(this);
        mNBtnDiet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(this, "hello "+condition, Toast.LENGTH_SHORT).show();
        switch (v.getId()) {
            case  R.id.iBtnJunk: {
                Intent myIntent = new Intent(v.getContext(), WorkRoutine.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
            case  R.id.iBtnBalanced: {
                Intent myIntent = new Intent(v.getContext(), WorkRoutine.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
            case  R.id.iBtnFFG: {
                Intent myIntent = new Intent(v.getContext(), WorkRoutine.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
            case  R.id.iBtnVegetarian: {
                Intent myIntent = new Intent(v.getContext(), WorkRoutine.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
            case  R.id.nBtnDiet: {
                Intent myIntent = new Intent(v.getContext(), WorkRoutine.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
        }
    }
}
