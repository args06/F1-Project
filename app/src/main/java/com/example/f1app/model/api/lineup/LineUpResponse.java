package com.example.f1app.model.api.lineup;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LineUpResponse{

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"LineUpResponse{" + 
			"results = '" + results + '\'' + 
			"}";
		}
}