package se.p950tes.publictransport.app.repository.type;

import com.google.gson.annotations.SerializedName;

public class StopDO {

	@SerializedName("id")
	private String id;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("area")
	private String area;
	
	@SerializedName("coordinate")
	private CoordinateDO coordinate;

	@SerializedName("type")
	private Integer type;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public CoordinateDO getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(CoordinateDO coordinate) {
		this.coordinate = coordinate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
