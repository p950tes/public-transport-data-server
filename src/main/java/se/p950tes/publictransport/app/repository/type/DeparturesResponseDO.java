package se.p950tes.publictransport.app.repository.type;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DeparturesResponseDO {

	@SerializedName("areaPoints")
	private List<AreaPointDO> areaPoints;
	
	@SerializedName("departures")
	private List<DepartureDO> departures;
	
	public List<AreaPointDO> getAreaPoints() {
		return areaPoints;
	}
	public void setAreaPoints(List<AreaPointDO> areaPoints) {
		this.areaPoints = areaPoints;
	}
	public List<DepartureDO> getDepartures() {
		return departures;
	}
	public void setDepartures(List<DepartureDO> departures) {
		this.departures = departures;
	}
}
