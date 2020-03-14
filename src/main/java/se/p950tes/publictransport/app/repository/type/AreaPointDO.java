package se.p950tes.publictransport.app.repository.type;

import com.google.gson.annotations.SerializedName;

public class AreaPointDO {

	@SerializedName("area")
	private String area;
	
	@SerializedName("coordinate")
	private CoordinateDO coordinate;
	
	public CoordinateDO getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(CoordinateDO coordinate) {
		this.coordinate = coordinate;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "AreaPoint [area=" + area + ", coordinate=" + coordinate + "]";
	}
}
