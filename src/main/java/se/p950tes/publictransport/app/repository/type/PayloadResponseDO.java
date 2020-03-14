package se.p950tes.publictransport.app.repository.type;

import com.google.gson.annotations.SerializedName;

/**
 * @param <P> Payload type
 */
public class PayloadResponseDO<P> {

	@SerializedName("StatusCode")
	private int statusCode;
	
	@SerializedName("Message")
	private int message;
	
	@SerializedName("Payload")
	private String payload;

	private transient P parsedPayload; 
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public P getParsedPayload() {
		return parsedPayload;
	}

	public void setParsedPayload(P parsedPayload) {
		this.parsedPayload = parsedPayload;
	}
}
