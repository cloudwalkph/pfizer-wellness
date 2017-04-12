package pfizer.wellness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ROEL on 4/10/2017.
 */

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iBtnGreat)
    ImageButton mIBtnGreat;

    @BindView(R.id.iBtnFine)
    ImageButton mIBtnFine;

    @BindView(R.id.iBtnNotWell)
    ImageButton mIBtnNotWell;

    Intent myIntent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        ButterKnife.bind(this);

        Toolbar tool_bar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tool_bar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mIBtnGreat.setOnClickListener(this);
        mIBtnFine.setOnClickListener(this);
        mIBtnNotWell.setOnClickListener(this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.iBtnGreat: {
                mIBtnGreat.setImageResource(R.drawable.onclickgreat);
                mIBtnFine.setImageResource(R.drawable.fine);
                mIBtnNotWell.setImageResource(R.drawable.notwell);
                myIntent = new Intent(v.getContext(), BMICalculator.class);

                new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            startActivityForResult(myIntent, 0);
                        }
                    },
                1000);
                break;
            }

            case R.id.iBtnFine: {
                mIBtnGreat.setImageResource(R.drawable.great);
                mIBtnFine.setImageResource(R.drawable.onclickfine);
                mIBtnNotWell.setImageResource(R.drawable.notwell);
                myIntent = new Intent(v.getContext(), BMICalculator.class);

                new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            startActivityForResult(myIntent, 0);
                        }
                    },
                1000);

                break;
            }

            case R.id.iBtnNotWell: {

                mIBtnGreat.setImageResource(R.drawable.great);
                mIBtnFine.setImageResource(R.drawable.fine);
                mIBtnNotWell.setImageResource(R.drawable.onclicknotwell);
                myIntent = new Intent(v.getContext(), BMICalculator.class);

                new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            startActivityForResult(myIntent, 0);
                        }
                    },
                1000);

                break;
            }

        }
    }

    private Runnable mMyRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            //Change state here
        }
    };
}
