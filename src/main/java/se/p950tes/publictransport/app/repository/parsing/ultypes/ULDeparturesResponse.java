package se.p950tes.publictransport.app.repository.parsing.ultypes;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ULDeparturesResponse {

	@SerializedName("areaPoints")
	private List<ULAreaPoint> areaPoints;
	
	@SerializedName("departures")
	private List<ULDeparture> departures;
	
	public List<ULAreaPoint> getAreaPoints() {
		return areaPoints;
	}
	public void setAreaPoints(List<ULAreaPoint> areaPoints) {
		this.areaPoints = areaPoints;
	}
	public List<ULDeparture> getDepartures() {
		return departures;
	}
	public void setDepartures(List<ULDeparture> departures) {
		this.departures = departures;
	}
}
