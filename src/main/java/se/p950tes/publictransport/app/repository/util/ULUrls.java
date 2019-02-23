package se.p950tes.publictransport.app.repository.util;

public class ULUrls {

	public static String getDeparturesUrl(int stopId) {
		return new UrlCreator("https://www.ul.se/api/stop/departures")
				.withParam("stopId", stopId)
				.build();
	}
	
	public static String getStopSearchUrl(String query) {
		return new UrlCreator("https://www.ul.se/api/journey/stops")
				.withParam("pointType", 0)
				.withParam("query", query)
				.build();
	}
}
