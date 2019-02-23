package se.p950tes.publictransport.app.repository.parsing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import se.p950tes.publictransport.app.repository.parsing.ultypes.ULDeparturesResponse;
import se.p950tes.publictransport.app.repository.parsing.ultypes.ULResponse;

public class DeparturesParser {

	public ULDeparturesResponse parse(String input) {
		
		Gson gson = new GsonBuilder().create();
		
		ULResponse response = gson.fromJson(input, ULResponse.class);
		ULDeparturesResponse busStopData = gson.fromJson(response.getPayload(), ULDeparturesResponse.class);
		
		return busStopData;
	}
}
