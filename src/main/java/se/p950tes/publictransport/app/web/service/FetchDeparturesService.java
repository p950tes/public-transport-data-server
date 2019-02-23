package se.p950tes.publictransport.app.web.service;

import se.p950tes.publictransport.app.repository.DeparturesRetriever;
import se.p950tes.publictransport.app.repository.parsing.ultypes.ULDeparture;
import se.p950tes.publictransport.app.repository.parsing.ultypes.ULDeparturesResponse;
import se.p950tes.publictransport.app.web.response.Departure;
import se.p950tes.publictransport.app.web.response.DeparturesResponse;

public class FetchDeparturesService {

	public DeparturesResponse fetchDepartures(int stopId) throws Exception {
		ULDeparturesResponse data = new DeparturesRetriever().fetch(stopId);
		
		return createResponse(data);
	}

	private DeparturesResponse createResponse(ULDeparturesResponse data) {
		DeparturesResponse response = new DeparturesResponse();
		for (ULDeparture departure : data.getDepartures()) {
			response.addDeparture(createDeparture(departure));
		}
		return response;
	}

	private Departure createDeparture(ULDeparture ulDeparture) {
		Departure departure = new Departure();
		departure.setLine(ulDeparture.getLine().getName());
		departure.setStopAreaId(ulDeparture.getAreaId());
		departure.setTime(ulDeparture.getNextDepartureTime());
		departure.setDestination(ulDeparture.getLine().getTowards());
		return departure;
	}
	
}
