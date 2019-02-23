package se.p950tes.publictransport.app.repository.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UrlCreator {

	private String baseUrl;
	private Map<String, String> parameters = new HashMap<>(); 
	
	public UrlCreator(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public UrlCreator withParam(String name) {
		parameters.put(name, null);
		return this;
	}
	public UrlCreator withParam(String name, Object value) {
		parameters.put(name, String.valueOf(value));
		return this;
	}
	
	public String build() {
		if (parameters.isEmpty()) {
			return baseUrl;
		}
		StringBuilder builder = new StringBuilder(baseUrl).append("?");
		for (Entry<String, String> param : parameters.entrySet()) {
			builder.append(urlEncode(param.getKey()));
			if (param.getValue() != null) {
				builder.append("=").append(urlEncode(param.getValue()));
			}
		}
		return builder.toString();
	}
	
	private String urlEncode(String valueToEncode) {
		return URLEncoder.encode(valueToEncode, StandardCharsets.UTF_8);
	}
	
	public static String getDeparturesUrl(int stopId) {
		return new StringBuilder("https://www.ul.se/api/stop/departures")
				.append("?stopId=")
				.append(stopId)
				.toString();
	}
}
