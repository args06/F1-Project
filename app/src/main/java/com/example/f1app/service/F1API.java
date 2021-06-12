package com.example.f1app.service;

import com.example.f1app.model.api.lineup.LineUpResponse;
import com.example.f1app.model.api.lineup.ResultsItem;
import com.example.f1app.model.api.race.EventsItem;
import com.example.f1app.model.api.race.RaceResponse;
import com.example.f1app.model.api.racer.PlayersItem;
import com.example.f1app.model.api.racer.RacerResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface F1API {
    String URL_BASE = "https://www.thesportsdb.com";

    @GET("/api/v1/json/1/eventspastleague.php?id=4370&s=2020")
    Call<RaceResponse> getRace();

    @GET("/api/v1/json/1/eventresults.php?")
    Call<ArrayList<ResultsItem>> getLineUp(@Query("id") String lineUpID);

    @GET("/api/v1/json/1/lookupplayer.php?")
    Call<ArrayList<PlayersItem>> getRacer(@Query("id") String racerID);
}
