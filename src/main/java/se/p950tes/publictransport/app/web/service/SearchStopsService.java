package se.p950tes.publictransport.app.web.service;

import java.util.LinkedList;
import java.util.List;

import se.p950tes.publictransport.app.repository.adapter.SearchStopsAdapter;
import se.p950tes.publictransport.app.repository.type.CoordinateDO;
import se.p950tes.publictransport.app.repository.type.StopDO;
import se.p950tes.publictransport.app.web.response.Coordinate;
import se.p950tes.publictransport.app.web.response.Stop;

public class SearchStopsService {

	public List<Stop> search(String query) throws Exception {
		List<StopDO> stops = new SearchStopsAdapter().fetch(query);
		
		return createResponse(stops);
	}

	private List<Stop> createResponse(List<StopDO> stops) {
		List<Stop> stopList = new LinkedList<>();
		for (StopDO departure : stops) {
			stopList.add(createDeparture(departure));
		}
		return stopList;
	}

	private Stop createDeparture(StopDO stopDO) {
		Stop stop = new Stop();
		stop.setId(stopDO.getId());
		stop.setName(stopDO.getName());
		stop.setCoordinate(createCoordinate(stopDO.getCoordinate()));
		return stop;
	}

	private Coordinate createCoordinate(CoordinateDO coordinateDO) {
		Coordinate coordinate = new Coordinate();
		coordinate.setLatitude(coordinateDO.getLatitude());
		coordinate.setLongitude(coordinateDO.getLongitude());
		return coordinate;
	}
	
}
