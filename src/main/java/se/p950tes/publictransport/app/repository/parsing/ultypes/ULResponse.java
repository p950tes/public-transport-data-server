package se.p950tes.publictransport.app.repository.parsing.ultypes;

import com.google.gson.annotations.SerializedName;

public class ULResponse {

	@SerializedName("StatusCode")
	private int statusCode;
	
	@SerializedName("Message")
	private int message;
	
	@SerializedName("Payload")
	private String payload;

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
}
