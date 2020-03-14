package se.p950tes.publictransport.app.repository.util;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

public class StopWatch {

	private final Clock clock;
	private Instant start;
	private Instant stop;

	public StopWatch() {
		this.clock = Clock.systemUTC();
	}
	public StopWatch(Clock clock) {
		this.clock = clock;
	}

	public void start() {
		start = Instant.now(clock);
	}
	public void stop() {
		stop = Instant.now(clock);
	}
	
	public Duration getTime() {
		return Duration.between(start, stop);
	}
}
