package se.p950tes.publictransport.app.repository.type;

import java.time.LocalTime;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import se.p950tes.publictransport.app.repository.parsing.LocalTimeAdapter;

public class DepartureDO {

	@SerializedName("area")
	private String areaId;
	
	@SerializedName("coordinate")
	private CoordinateDO coordinates;
	
	@SerializedName("nextDepartureTime")
	@JsonAdapter(LocalTimeAdapter.class)
	private LocalTime nextDepartureTime;
	
	@SerializedName("nextDepartureIn")
	private int nextDepartureInMinutes;
	
	@SerializedName("line")
	private LineDO line;
	
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String area) {
		this.areaId = area;
	}
	public CoordinateDO getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(CoordinateDO coordinate) {
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
	public LineDO getLine() {
		return line;
	}
	public void setLine(LineDO line) {
		this.line = line;
	}
	@Override
	public String toString() {
		return "Departure [area=" + areaId + ", coordinate=" + coordinates + ", nextDepartureTime=" + nextDepartureTime
				+ ", nextDepartureIn=" + nextDepartureInMinutes + ", line=" + line + "]";
	}
}
