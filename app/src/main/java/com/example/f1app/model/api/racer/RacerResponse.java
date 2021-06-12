package com.example.f1app.model.api.racer;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RacerResponse{

	@SerializedName("players")
	private List<PlayersItem> players;

	public void setPlayers(List<PlayersItem> players){
		this.players = players;
	}

	public List<PlayersItem> getPlayers(){
		return players;
	}

	@Override
 	public String toString(){
		return 
			"RacerResponse{" + 
			"players = '" + players + '\'' + 
			"}";
		}
}