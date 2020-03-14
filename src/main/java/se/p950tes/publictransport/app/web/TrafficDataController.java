package se.p950tes.publictransport.app.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import se.p950tes.publictransport.app.web.response.Departure;
import se.p950tes.publictransport.app.web.response.Stop;
import se.p950tes.publictransport.app.web.service.FetchDeparturesService;
import se.p950tes.publictransport.app.web.service.SearchStopsService;

@RestController
public class TrafficDataController {

	
	@RequestMapping(value="/stops/{id}/departures", method = RequestMethod.GET)
	public List<Departure> departures(@PathVariable int id) throws Exception {
		System.out.println("StopId requested: " + id);
		return new FetchDeparturesService().fetchDepartures(id);
	}
	
	@RequestMapping(value="/stops", method = RequestMethod.GET)
	public List<Stop> stops(@RequestParam(name = "q", required = true) String query) throws Exception {
		System.out.println("Query: " + query);
		return new SearchStopsService().search(query);
	}
}
