package se.p950tes.publictransport.app.repository.type;

import com.google.gson.annotations.SerializedName;

public class LineDO {

	@SerializedName("lineNo")
	private Integer lineNo;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("towards")
	private String towards;
	
	@SerializedName("trafficType")
	private Integer trafficType;

	public Integer getLineNo() {
		return lineNo;
	}
	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTowards() {
		return towards;
	}
	public void setTowards(String towards) {
		this.towards = towards;
	}
	public Integer getTrafficType() {
		return trafficType;
	}
	public void setTrafficType(Integer trafficType) {
		this.trafficType = trafficType;
	}
	@Override
	public String toString() {
		return "Line [lineNo=" + lineNo + ", name=" + name + ", towards=" + towards + ", trafficType=" + trafficType + "]";
	}
}
