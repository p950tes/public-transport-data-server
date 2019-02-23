package se.p950tes.publictransport.app.web.response;

import java.util.LinkedList;
import java.util.List;

public class DeparturesResponse {

	private List<Departure> departures = new LinkedList<>();

	public List<Departure> getDepartures() {
		return departures;
	}

	public void setDepartures(List<Departure> departures) {
		this.departures = departures;
	}
	public void addDeparture(Departure departure) {
		departures.add(departure);
	}
}
