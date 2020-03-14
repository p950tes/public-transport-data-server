package se.p950tes.publictransport.app.web.response;

public class Stop {

	private String id;
	private String name;
	private Coordinate coordinate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
