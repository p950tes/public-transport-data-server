package se.p950tes.publictransport.app.repository.parsing.ultypes;

import com.google.gson.annotations.SerializedName;

public class ULAreaPoint {

	@SerializedName("area")
	private String area;
	
	@SerializedName("coordinate")
	private ULCoordinates coordinate;
	
	public ULCoordinates getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(ULCoordinates coordinate) {
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
