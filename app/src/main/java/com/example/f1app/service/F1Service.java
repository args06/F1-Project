package com.example.f1app.service;

import com.example.f1app.model.api.lineup.LineUpResponse;
import com.example.f1app.model.api.lineup.ResultsItem;
import com.example.f1app.model.api.race.EventsItem;
import com.example.f1app.model.api.race.RaceResponse;
import com.example.f1app.model.api.racer.PlayersItem;
import com.example.f1app.model.api.racer.RacerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class F1Service {
    private Retrofit retrofit = null;

    public F1API getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(F1API.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(F1API.class);
    }

    public void getRace(final F1Listener<List<EventsItem>> listener){
        getAPI().getRace().enqueue(new Callback<RaceResponse>() {
            @Override
            public void onResponse(Call<RaceResponse> call, Response<RaceResponse> response) {
                RaceResponse data = response.body();
                if(data != null && data.getEvents() != null){
                    listener.onSuccess(data.getEvents());
                }
            }

            @Override
            public void onFailure(Call<RaceResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getLineUp(final F1Listener<List<ResultsItem>> listener, String eventID){
        getAPI().getLineUp(eventID).enqueue(new Callback<LineUpResponse>() {
            @Override
            public void onResponse(Call<LineUpResponse> call, Response<LineUpResponse> response) {
                LineUpResponse data = response.body();
                if(data != null && data.getResults() != null){
                    listener.onSuccess(data.getResults());
                }
            }

            @Override
            public void onFailure(Call<LineUpResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getRacerProfile(final F1Listener<List<PlayersItem>> listener, String eventID){
        getAPI().getRacer(eventID).enqueue(new Callback<RacerResponse>() {
            @Override
            public void onResponse(Call<RacerResponse> call, Response<RacerResponse> response) {
                RacerResponse data = response.body();
                if(data != null && data.getPlayers() != null){
                    listener.onSuccess(data.getPlayers());
                }
            }

            @Override
            public void onFailure(Call<RacerResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

}
