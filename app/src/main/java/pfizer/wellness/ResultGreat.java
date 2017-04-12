package pfizer.wellness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ROEL on 4/10/2017.
 */

public class ResultGreat extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.ivResult)
    ImageView mIVResult;

    @BindView(R.id.btnRecommended)
    Button mBtnRecommended;

    int condition = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_great);

        ButterKnife.bind(this);

        condition = getIntent().getIntExtra("condition", 0);
//        Toast.makeText(this, "hello "+condition, Toast.LENGTH_SHORT).show();

        if( condition == 1 ){
//            mIVResult.setImageResource(R.drawable.needimprovement);
            mIVResult.setImageDrawable(getResources().getDrawable(R.drawable.needimprovement));
        }else if ( condition == 2 ){
//            mIVResult.setImageResource(R.drawable.greatimprovement);
            mIVResult.setImageDrawable(getResources().getDrawable(R.drawable.greatimprovement));
        }else if ( condition == 3 ){
//            mIVResult.setImageResource(R.drawable.good);
            mIVResult.setImageDrawable(getResources().getDrawable(R.drawable.good));
        }else{
//            mIVResult.setImageResource(R.drawable.needattention);
            mIVResult.setImageDrawable(getResources().getDrawable(R.drawable.needattention));
        }

        mBtnRecommended.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btnRecommended: {
                Intent myIntent = new Intent(v.getContext(), Products.class);
                myIntent.putExtra("condition", condition);
                startActivityForResult(myIntent, 0);
                break;
            }
        }
    }
}
