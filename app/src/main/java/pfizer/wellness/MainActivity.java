package pfizer.wellness;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_begin)
    Button mBtnBegin;
    View dialogLayout;

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
                dialogShow(v);
                break;
            }
        }
    }

    public void dialogShow(final View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Agree", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                Intent myIntent = new Intent(v.getContext(), CustomerDetails.class);
                startActivityForResult(myIntent, 0);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Disagree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        final AlertDialog dialog = builder.create();
        LayoutInflater inflater = getLayoutInflater();
        dialogLayout = inflater.inflate(R.layout.dialog_concent, null);

        dialog.setView(dialogLayout);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.show();

    }
}
