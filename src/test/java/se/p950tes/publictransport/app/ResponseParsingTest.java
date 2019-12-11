package se.p950tes.publictransport.app;

import org.junit.Test;

import se.p950tes.publictransport.app.repository.DeparturesRetriever;
import se.p950tes.publictransport.app.repository.parsing.ultypes.ULAreaPoint;
import se.p950tes.publictransport.app.repository.parsing.ultypes.ULDeparture;
import se.p950tes.publictransport.app.repository.parsing.ultypes.ULDeparturesResponse;

public class ResponseParsingTest {

	private static final int ID_KLOCKARANGEN = 700552;
	
	
	@Test
	public void test1() throws Exception {
		
		ULDeparturesResponse data = new DeparturesRetriever().fetch(ID_KLOCKARANGEN);
		
		System.out.println("Areapoints");
		for (ULAreaPoint areapoint : data.getAreaPoints()) {
			System.out.println(areapoint);
		}
		
		System.out.println("departures");
		
		for (ULDeparture departure : data.getDepartures()) {
			System.out.println(departure);
//			Line line = departure.getLine();
//			System.out.println(line + " " + departure.getNextDepartureTime());
		}
	}
}
