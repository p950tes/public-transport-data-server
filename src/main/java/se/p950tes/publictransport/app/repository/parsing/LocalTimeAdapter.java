package se.p950tes.publictransport.app.repository.parsing;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalTimeAdapter extends TypeAdapter<LocalTime> {

//	private final DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_TIME;
	// ISO_LOCAL_TIME does not support single digit hours.
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("H:mm");
	
	@Override
	public void write(JsonWriter out, LocalTime value) throws IOException {
		value.format(format);
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public LocalTime read(JsonReader in) throws IOException {
		String stringValue = in.nextString();
		return LocalTime.parse(stringValue, format);
	}

}

