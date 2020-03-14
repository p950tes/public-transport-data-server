package se.p950tes.publictransport.app.repository.parsing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import se.p950tes.publictransport.app.exception.ResponseParsingException;
import se.p950tes.publictransport.app.repository.type.PayloadResponseDO;

public class JsonParser {

	public <T> T parse(String input, Class<T> typeToParse) {
		try {
			Gson gson = new GsonBuilder().create();
			return gson.fromJson(input, typeToParse);
		} catch (Exception e) {
			throw new ResponseParsingException("Failed to parse URL response [" + input + "]", e);
		}
	}
	
	public <P> PayloadResponseDO<P> parsePayloadResponse(String input, Class<P> payloadType) {
		
		@SuppressWarnings("unchecked")
		PayloadResponseDO<P> response = parse(input, PayloadResponseDO.class);
		
		P payload = parse(response.getPayload(), payloadType);
		response.setParsedPayload(payload);
		return response;
	}
}
