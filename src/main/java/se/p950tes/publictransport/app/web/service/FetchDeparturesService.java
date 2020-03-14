package se.p950tes.publictransport.app.web.service;

import java.util.LinkedList;
import java.util.List;

import se.p950tes.publictransport.app.exception.NotFoundException;
import se.p950tes.publictransport.app.exception.UnknownULException;
import se.p950tes.publictransport.app.repository.adapter.FetchDeparturesAdapter;
import se.p950tes.publictransport.app.repository.type.DepartureDO;
import se.p950tes.publictransport.app.repository.type.DeparturesResponseDO;
import se.p950tes.publictransport.app.repository.type.PayloadResponseDO;
import se.p950tes.publictransport.app.web.response.Departure;

public class FetchDeparturesService {

	private static final int RESPONSE_CODE_NOT_FOUND = 20320;
	
	public List<Departure> fetchDepartures(int stopId) throws Exception {
		PayloadResponseDO<DeparturesResponseDO> data = new FetchDeparturesAdapter().fetch(stopId);
		
		validateResponse(stopId, data);
		
		return createResponse(data.getParsedPayload());
	}
	
	private void validateResponse(int busStopId, PayloadResponseDO<DeparturesResponseDO> data) {
		int statusCode = data.getStatusCode();
		if (statusCode == RESPONSE_CODE_NOT_FOUND) {
			throw new NotFoundException("Bus stop with ID " + busStopId + " not found");
		}
		if (statusCode != 0) {
			throw new UnknownULException("UL returned unknown status code " + statusCode + " for bus stop " + busStopId);
		}
	}

	private List<Departure> createResponse(DeparturesResponseDO departuresDO) {
		List<Departure> departures = new LinkedList<>();
		for (DepartureDO departure : departuresDO.getDepartures()) {
			departures.add(createDeparture(departure));
		}
		return departures;
	}

	private Departure createDeparture(DepartureDO ulDeparture) {
		Departure departure = new Departure();
		departure.setLine(ulDeparture.getLine().getName());
		departure.setStopAreaId(ulDeparture.getAreaId());
		departure.setTime(ulDeparture.getNextDepartureTime());
		departure.setDestination(ulDeparture.getLine().getTowards());
		return departure;
	}
	
}
