package se.p950tes.publictransport.app.repository.adapter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.logging.Logger;

import se.p950tes.publictransport.app.repository.parsing.JsonParser;
import se.p950tes.publictransport.app.repository.type.DeparturesResponseDO;
import se.p950tes.publictransport.app.repository.type.PayloadResponseDO;
import se.p950tes.publictransport.app.repository.util.UrlCreator;

public class FetchDeparturesAdapter {

	private static final Duration CONNECT_TIMEOUT = Duration.ofSeconds(1);
	private static final Duration READ_TIMEOUT = Duration.ofSeconds(3);
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	public PayloadResponseDO<DeparturesResponseDO> fetch(int stopId) throws Exception {
		
		HttpClient client = HttpClient.newBuilder()
				.connectTimeout(CONNECT_TIMEOUT)
				.build();

		URI requestUri = new UrlCreator("https://www.ul.se/api/stop/departures")
				.withParam("stopId", stopId)
				.build();
		
		HttpRequest request = HttpRequest.newBuilder()
		        .uri(requestUri)
		        .timeout(READ_TIMEOUT)
		        .header("Content-Type", "application/json")
		        .GET()
		        .build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		String retrievedData = response.body();
		logger.info(retrievedData);

		PayloadResponseDO<DeparturesResponseDO> data = parseResponse(retrievedData);
		return data;
	}

	private PayloadResponseDO<DeparturesResponseDO> parseResponse(String retrievedData) {
		JsonParser parser = new JsonParser();
		return parser.parsePayloadResponse(retrievedData, DeparturesResponseDO.class);
	}
}
