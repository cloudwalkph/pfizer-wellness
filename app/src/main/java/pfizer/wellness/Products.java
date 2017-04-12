package pfizer.wellness;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ROEL on 4/11/2017.
 */

public class Products extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.pBtnDone)
    Button mBtnDone;

    @BindView(R.id.iBcentrumadvance)
    ImageButton mBcentrumadvance;

    @BindView(R.id.iBcentrumsilveradvance)
    ImageButton mBcentrumsilveradvance;

    @BindView(R.id.iBadvil)
    ImageButton mBadvil;

    @BindView(R.id.iCaltrate)
    ImageButton mCaltrate;

    @BindView(R.id.iRobitussin)
    ImageButton mRobitussin;

    @BindView(R.id.iStresstabs)
    ImageButton mStresstabs;

    @BindView(R.id.iIncremin)
    ImageButton mIncremin;

    @BindView(R.id.iChildrensClusivol)
    ImageButton mChildrensClusivol;

    @BindView(R.id.iRobikids)
    ImageButton mRobikids;

    @BindView(R.id.iDimetapp)
    ImageButton mDimetapp;

    @BindView(R.id.iLoviscol)
    ImageButton miLoviscol;

    @BindView(R.id.iAdvilSuspension)
    ImageButton miAdvilSuspension;

    @BindView(R.id.iClusivolPlus)
    ImageButton miClusivolPlus;

    @BindView(R.id.iChapstick)
    ImageButton miChapstick;

    Context context;

    View dialogLayout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);

        ButterKnife.bind(this);

        mBtnDone.setOnClickListener(this);
        mBcentrumadvance.setOnClickListener(this);
        mBcentrumsilveradvance.setOnClickListener(this);
        mBadvil.setOnClickListener(this);
        mCaltrate.setOnClickListener(this);
        mRobitussin.setOnClickListener(this);
        mStresstabs.setOnClickListener(this);
        mIncremin.setOnClickListener(this);
        mChildrensClusivol.setOnClickListener(this);
        mRobikids.setOnClickListener(this);
        mDimetapp.setOnClickListener(this);
        miLoviscol.setOnClickListener(this);
        miAdvilSuspension.setOnClickListener(this);
        miClusivolPlus.setOnClickListener(this);
        miChapstick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Medicine medicineAdapter = new Medicine(Products.this);

        switch (v.getId()) {
            case  R.id.pBtnDone: {
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
                break;
            }
            case  R.id.iBcentrumadvance: {
                dialogShow(0);
                break;
            }
            case  R.id.iBcentrumsilveradvance: {
                dialogShow(1);
                break;
            }
            case  R.id.iBadvil: {
                dialogShow(2);
                break;
            }
            case  R.id.iCaltrate: {
                dialogShow(3);
                break;
            }
            case  R.id.iRobitussin: {
                dialogShow(4);
                break;
            }
            case  R.id.iStresstabs: {
                dialogShow(5);
                break;
            }
            case  R.id.iIncremin: {
                dialogShow(6);
                break;
            }
            case  R.id.iChildrensClusivol: {
                dialogShow(7);
                break;
            }
            case  R.id.iRobikids: {
                dialogShow(8);
                break;
            }
            case  R.id.iDimetapp: {
                dialogShow(9);
                break;
            }
            case  R.id.iLoviscol: {
                dialogShow(10);
                break;
            }
            case  R.id.iAdvilSuspension: {
                dialogShow(11);
                break;
            }
            case  R.id.iClusivolPlus: {
                dialogShow(12);
                break;
            }
            case  R.id.iChapstick: {
                dialogShow(13);
                break;
            }
        }
    }

    public void dialogShow(int i){
        int[] productImageList = new int[]{
                R.drawable.fullcentrumadvance,
                R.drawable.fullcentrumsilver,
                R.drawable.fulladvil,
                R.drawable.fullcaltrate,
                R.drawable.fullrobitussin,
                R.drawable.fullstresstabs,
                R.drawable.fullincremin,
                R.drawable.fullclusivolkids,
                R.drawable.fullrobikids,
                R.drawable.fulldimetapp,
                R.drawable.fullloviscol,
                R.drawable.fulladvilkids,
                R.drawable.fullclusivol,
                R.drawable.fullchapstick
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        final AlertDialog dialog = builder.create();
        LayoutInflater inflater = getLayoutInflater();
        dialogLayout = inflater.inflate(R.layout.dialog_products, null);

        ImageView image = (ImageView) dialogLayout.findViewById(R.id.productImage);

        image.setImageResource(productImageList[i]);

        dialog.setView(dialogLayout);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.show();

    }
}
