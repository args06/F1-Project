package com.example.f1app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.f1app.adapter.LineUpAdapter;
import com.example.f1app.adapter.RaceAdapter;
import com.example.f1app.model.api.lineup.ResultsItem;
import com.example.f1app.model.api.race.EventsItem;
import com.example.f1app.service.F1Listener;
import com.example.f1app.service.F1Service;

import java.util.List;

public class LineupActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";

    TextView tvRaceTitle;
    RecyclerView rvLineUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineup);

        EventsItem item = getIntent().getParcelableExtra(EXTRA_DATA);

        tvRaceTitle = findViewById(R.id.tv_title_lineup);
        tvRaceTitle.setText(item.getStrEvent());

        rvLineUp = findViewById(R.id.rv_lineup);

        new F1Service().getLineUp(lineUpListener, item.getIdEvent());
    }

    F1Listener<List<ResultsItem>> lineUpListener = new F1Listener<List<ResultsItem>>(){

        @Override
        public void onSuccess(List<ResultsItem> items) {

            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvLineUp.setLayoutManager(linearLayoutManager);
            LineUpAdapter rvAdapter = new LineUpAdapter(items);
            rvLineUp.setAdapter(rvAdapter);

            for(int i = 0; i < items.size(); i++){
                Log.d("Hasil : PLAYER NAME -> ", items.get(i).getStrPlayer());
                Log.d("Hasil : POSITION -> ", String.valueOf(items.get(i).getIntPosition()));
            }
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR", msg);
        }
    };
}