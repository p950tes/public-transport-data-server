package se.p950tes.publictransport.app.repository.adapter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import se.p950tes.publictransport.app.repository.parsing.JsonParser;
import se.p950tes.publictransport.app.repository.type.StopDO;
import se.p950tes.publictransport.app.repository.util.UrlCreator;

public class SearchStopsAdapter {

	private static final Duration CONNECT_TIMEOUT = Duration.ofSeconds(1);
	private static final Duration READ_TIMEOUT = Duration.ofSeconds(3);
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	public List<StopDO> fetch(String query) throws Exception {
		
		HttpClient client = HttpClient.newBuilder()
				.connectTimeout(CONNECT_TIMEOUT)
				.build();

		URI requestUri = new UrlCreator("https://www.ul.se/api/journey/stops")
				.withParam("pointType", 0)
				.withParam("query", query)
				.build();
		
		logger.info(requestUri.toASCIIString());
		
		HttpRequest request = HttpRequest.newBuilder()
		        .uri(requestUri)
		        .timeout(READ_TIMEOUT)
		        .header("Content-Type", "application/json")
		        .GET()
		        .build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		String retrievedData = response.body();
		logger.info(retrievedData);

		List<StopDO> data = parseResponse(retrievedData);
		return data;
	}

	private List<StopDO> parseResponse(String retrievedData) {
		JsonParser parser = new JsonParser();
		StopDO[] stopArray = parser.parse(retrievedData, StopDO[].class);
		return Arrays.asList(stopArray);
	}
}
