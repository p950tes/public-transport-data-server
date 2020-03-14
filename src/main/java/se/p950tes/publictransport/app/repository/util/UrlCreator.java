package se.p950tes.publictransport.app.repository.util;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class UrlCreator {

	private final String baseUrl;
	private final List<String> parameters = new LinkedList<>(); 
	
	public UrlCreator(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public UrlCreator withParam(String name) {
		return withParam(name, null);
	}
	public UrlCreator withParam(String name, Object value) {
		StringBuilder builder = new StringBuilder(urlEncode(name));
		if (value != null) {
			builder.append("=");
			builder.append(urlEncode(String.valueOf(value)));
		}
		parameters.add(builder.toString());
		return this;
	}
	
	public URI build() {
		if (parameters.isEmpty()) {
			return URI.create(baseUrl);
		}
		String queryString = buildQueryString(parameters);
		return URI.create(baseUrl + "?" + queryString);
	}

	private static String buildQueryString(List<String> parameters) {
		StringBuilder builder = new StringBuilder();
		
		int lastParamIndex = parameters.size() - 1;
		
		for (int i = 0; i < parameters.size(); i++) {
			String param = parameters.get(i);
			builder.append(param);
			
			if (i != lastParamIndex) {
				builder.append("&");
			}
		}
		return builder.toString();
	}
	
	private static String urlEncode(String valueToEncode) {
		return URLEncoder.encode(valueToEncode, StandardCharsets.UTF_8);
	}
}
