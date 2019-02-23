package se.p950tes.publictransport.app.repository.parsing.ultypes;

import java.time.LocalTime;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import se.p950tes.publictransport.app.repository.parsing.LocalTimeAdapter;

public class ULDeparture {

	@SerializedName("area")
	private String areaId;
	
	@SerializedName("coordinate")
	private ULCoordinates coordinates;
	
	@SerializedName("nextDepartureTime")
	@JsonAdapter(LocalTimeAdapter.class)
	private LocalTime nextDepartureTime;
	
	@SerializedName("nextDepartureIn")
	private int nextDepartureInMinutes;
	
	@SerializedName("line")
	private ULLine line;
	
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String area) {
		this.areaId = area;
	}
	public ULCoordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(ULCoordinates coordinate) {
		this.coordinates = coordinate;
	}
	public LocalTime getNextDepartureTime() {
		return nextDepartureTime;
	}
	public void setNextDepartureTime(LocalTime nextDepartureTime) {
		this.nextDepartureTime = nextDepartureTime;
	}
	public int getNextDepartureInMinutes() {
		return nextDepartureInMinutes;
	}
	public void setNextDepartureInMinutes(int nextDepartureIn) {
		this.nextDepartureInMinutes = nextDepartureIn;
	}
	public ULLine getLine() {
		return line;
	}
	public void setLine(ULLine line) {
		this.line = line;
	}
	@Override
	public String toString() {
		return "Departure [area=" + areaId + ", coordinate=" + coordinates + ", nextDepartureTime=" + nextDepartureTime
				+ ", nextDepartureIn=" + nextDepartureInMinutes + ", line=" + line + "]";
	}
}
