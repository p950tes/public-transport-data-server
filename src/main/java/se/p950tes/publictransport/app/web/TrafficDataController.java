package se.p950tes.publictransport.app.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import se.p950tes.publictransport.app.web.response.DeparturesResponse;
import se.p950tes.publictransport.app.web.service.FetchDeparturesService;

@RestController
public class TrafficDataController {

	
	@RequestMapping(value="/departures/{id}", method = RequestMethod.GET)
	public DeparturesResponse departures(@PathVariable int id) throws Exception {
		System.out.println("StopId requested: " + id);
		return new FetchDeparturesService().fetchDepartures(id);
	}
}
