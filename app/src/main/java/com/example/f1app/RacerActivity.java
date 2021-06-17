package com.example.f1app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.example.f1app.model.api.lineup.ResultsItem;
import com.example.f1app.model.api.racer.PlayersItem;
import com.example.f1app.service.F1Listener;
import com.example.f1app.service.F1Service;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class RacerActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";
    private ResultsItem item;

    TextView tvTitle, tvName, tvBirth, tvTeam, tvDesc;
    ImageView ivBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racer);

        item = getIntent().getParcelableExtra(EXTRA_DATA);

        new F1Service().getRacerProfile(profileListener, item.getIdPlayer());
    }

    F1Listener<List<PlayersItem>> profileListener = new F1Listener<List<PlayersItem>>(){

        @SuppressLint("SetTextI18n")
        @Override
        public void onSuccess(List<PlayersItem> items) {

            tvTitle = findViewById(R.id.tv_title_racer);
            tvTitle.setText(items.get(0).getStrPlayer()+"'s Profile");

            ivBanner = findViewById(R.id.ivBanner);
            if(items.get(0).getStrBanner() == null){
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics());
                ivBanner.getLayoutParams().height = dimensionInDp;
                ivBanner.getLayoutParams().width = dimensionInDp;
                ivBanner.requestLayout();
            } else {
                Glide.with(getApplicationContext())
                        .load(items.get(0).getStrBanner())
                        .into(ivBanner);
            }


            tvName = findViewById(R.id.tv_racer_name);
            tvName.setText(": "+items.get(0).getStrPlayer());

            tvBirth = findViewById(R.id.tv_birth);
            tvBirth.setText(": "+items.get(0).getStrBirthLocation()+", "+items.get(0).getDateBorn());

            tvTeam = findViewById(R.id.tv_team);
            tvTeam.setText(": "+items.get(0).getStrTeam());

            tvDesc = findViewById(R.id.tv_racer_desc);
            tvDesc.setText("\t\t\t\t\t"+ StringUtils.substringBefore(items.get(0).getStrDescriptionEN(), "\r\n"));



            for(int i = 0; i < items.size(); i++){
                Log.d("Hasil : PLAYER NAME -> ", items.get(i).getStrPlayer());
                Log.d("Hasil : POSITION -> ", String.valueOf(items.get(i).getStrBirthLocation()));
            }
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR", msg);
        }
    };
}