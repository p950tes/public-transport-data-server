package se.p950tes.publictransport.app.repository.util;

import java.net.URI;

public class ULUrls {

	public static URI getStopSearchUrl(String query) {
		return new UrlCreator("https://www.ul.se/api/journey/stops")
				.withParam("pointType", 0)
				.withParam("query", query)
				.build();
	}
}
