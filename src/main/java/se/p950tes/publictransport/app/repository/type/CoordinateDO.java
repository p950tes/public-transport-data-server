package se.p950tes.publictransport.app.repository.type;

import com.google.gson.annotations.SerializedName;

public class CoordinateDO {

	@SerializedName("longitude")
	private Double longitude;
	
	@SerializedName("latitude")
	private Double latitude;
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Coordinate [longitude=" + longitude + ", latitude=" + latitude + "]";
	}
}
