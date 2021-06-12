package com.example.f1app.model.api.race;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RaceResponse{

	@SerializedName("events")
	private List<EventsItem> events;

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}

	@Override
 	public String toString(){
		return 
			"RaceResponse{" + 
			"events = '" + events + '\'' + 
			"}";
		}
}