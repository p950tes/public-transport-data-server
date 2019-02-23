package se.p950tes.publictransport.app.web.response;

import java.time.LocalTime;

public class Departure {

	private String stopAreaId;
	private String line;
	private String destination;
	private LocalTime time;

	public String getStopAreaId() {
		return stopAreaId;
	}
	public void setStopAreaId(String stopAreaId) {
		this.stopAreaId = stopAreaId;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
}
