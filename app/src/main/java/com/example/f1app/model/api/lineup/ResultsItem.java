package com.example.f1app.model.api.lineup;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {

	@SerializedName("strPlayer")
	private String strPlayer;

	@SerializedName("intPoints")
	private String intPoints;

	@SerializedName("idResult")
	private String idResult;

	@SerializedName("idEvent")
	private String idEvent;

	@SerializedName("strSport")
	private String strSport;

	@SerializedName("strEvent")
	private String strEvent;

	@SerializedName("idTeam")
	private String idTeam;

	@SerializedName("strResult")
	private Object strResult;

	@SerializedName("dateEvent")
	private String dateEvent;

	@SerializedName("idPlayer")
	private String idPlayer;

	@SerializedName("intPosition")
	private String intPosition;

	@SerializedName("strCountry")
	private String strCountry;

	@SerializedName("strDetail")
	private String strDetail;

	@SerializedName("strSeason")
	private String strSeason;

	protected ResultsItem(Parcel in) {
		strPlayer = in.readString();
		intPoints = in.readString();
		idResult = in.readString();
		idEvent = in.readString();
		strSport = in.readString();
		strEvent = in.readString();
		idTeam = in.readString();
		dateEvent = in.readString();
		idPlayer = in.readString();
		intPosition = in.readString();
		strCountry = in.readString();
		strDetail = in.readString();
		strSeason = in.readString();
	}

	public static final Creator<ResultsItem> CREATOR = new Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel in) {
			return new ResultsItem(in);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};

	public void setStrPlayer(String strPlayer){
		this.strPlayer = strPlayer;
	}

	public String getStrPlayer(){
		return strPlayer;
	}

	public void setIntPoints(String intPoints){
		this.intPoints = intPoints;
	}

	public String getIntPoints(){
		return intPoints;
	}

	public void setIdResult(String idResult){
		this.idResult = idResult;
	}

	public String getIdResult(){
		return idResult;
	}

	public void setIdEvent(String idEvent){
		this.idEvent = idEvent;
	}

	public String getIdEvent(){
		return idEvent;
	}

	public void setStrSport(String strSport){
		this.strSport = strSport;
	}

	public String getStrSport(){
		return strSport;
	}

	public void setStrEvent(String strEvent){
		this.strEvent = strEvent;
	}

	public String getStrEvent(){
		return strEvent;
	}

	public void setIdTeam(String idTeam){
		this.idTeam = idTeam;
	}

	public String getIdTeam(){
		return idTeam;
	}

	public void setStrResult(Object strResult){
		this.strResult = strResult;
	}

	public Object getStrResult(){
		return strResult;
	}

	public void setDateEvent(String dateEvent){
		this.dateEvent = dateEvent;
	}

	public String getDateEvent(){
		return dateEvent;
	}

	public void setIdPlayer(String idPlayer){
		this.idPlayer = idPlayer;
	}

	public String getIdPlayer(){
		return idPlayer;
	}

	public void setIntPosition(String intPosition){
		this.intPosition = intPosition;
	}

	public String getIntPosition(){
		return intPosition;
	}

	public void setStrCountry(String strCountry){
		this.strCountry = strCountry;
	}

	public String getStrCountry(){
		return strCountry;
	}

	public void setStrDetail(String strDetail){
		this.strDetail = strDetail;
	}

	public String getStrDetail(){
		return strDetail;
	}

	public void setStrSeason(String strSeason){
		this.strSeason = strSeason;
	}

	public String getStrSeason(){
		return strSeason;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"strPlayer = '" + strPlayer + '\'' + 
			",intPoints = '" + intPoints + '\'' + 
			",idResult = '" + idResult + '\'' + 
			",idEvent = '" + idEvent + '\'' + 
			",strSport = '" + strSport + '\'' + 
			",strEvent = '" + strEvent + '\'' + 
			",idTeam = '" + idTeam + '\'' + 
			",strResult = '" + strResult + '\'' + 
			",dateEvent = '" + dateEvent + '\'' + 
			",idPlayer = '" + idPlayer + '\'' + 
			",intPosition = '" + intPosition + '\'' + 
			",strCountry = '" + strCountry + '\'' + 
			",strDetail = '" + strDetail + '\'' + 
			",strSeason = '" + strSeason + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(strPlayer);
		dest.writeString(intPoints);
		dest.writeString(idResult);
		dest.writeString(idEvent);
		dest.writeString(strSport);
		dest.writeString(strEvent);
		dest.writeString(idTeam);
		dest.writeString(dateEvent);
		dest.writeString(idPlayer);
		dest.writeString(intPosition);
		dest.writeString(strCountry);
		dest.writeString(strDetail);
		dest.writeString(strSeason);
	}
}