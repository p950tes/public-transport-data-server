package se.p950tes.publictransport.app.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.p950tes.publictransport.app.web.response.DeparturesResponse;
import se.p950tes.publictransport.app.web.service.FetchDeparturesService;

@RestController
public class TrafficDataController {

	
	@RequestMapping("/departures")
	public DeparturesResponse departures(int stopId) throws Exception {
		return new FetchDeparturesService().fetchDepartures(stopId);
	}
}
