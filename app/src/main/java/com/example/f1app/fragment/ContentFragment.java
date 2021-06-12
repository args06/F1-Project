package com.example.f1app.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.f1app.service.F1Listener;
import com.example.f1app.R;
import com.example.f1app.model.api.race.EventsItem;
import com.example.f1app.service.F1Service;

import java.util.List;

public class ContentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new F1Service().getRace(raceListener);
    }

    F1Listener<List<EventsItem>> raceListener = new F1Listener<List<EventsItem>>(){

        @Override
        public void onSuccess(List<EventsItem> items) {
            for(int i = 0; i < items.size(); i++){
                Log.d("Hasil : NAMA KOTA -> ", items.get(i).getStrEvent());
                Log.d("Hasil : CONFIRMED -> ", String.valueOf(items.get(i).getDateEvent()));
            }
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR", msg);
        }
    };
}