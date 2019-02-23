package se.p950tes.publictransport.app.repository.datasource;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class HttpDataSource implements DataSource {

	private static final int CONNECT_TIMEOUT = 2;
	private static final int READ_TIMEOUT = 5;
	
	private String url;
	
	public HttpDataSource(String url) {
		this.url = url;
	}

	@Override
	public String fetchData() throws Exception {
		
		HttpClient client = createHttpClient();
		HttpRequest request = createRequest();

		long currentTime = System.currentTimeMillis();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - currentTime));
		return response.body();
	}

	private HttpClient createHttpClient() {
		return HttpClient.newBuilder()
		        .version(Version.HTTP_2)
		        .followRedirects(Redirect.NORMAL)
		        .connectTimeout(Duration.ofSeconds(CONNECT_TIMEOUT))
		        .build();
	}
	
	private HttpRequest createRequest() {
		 return HttpRequest.newBuilder()
		        .uri(URI.create(url))
		        .timeout(Duration.ofSeconds(READ_TIMEOUT))
		        .header("Content-Type", "application/json")
		        .GET()
		        .build();
	}
}
