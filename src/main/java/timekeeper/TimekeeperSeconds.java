package timekeeper;

import java.time.Duration;
import java.time.Instant;

public class TimekeeperSeconds implements Runnable, Questionable {

    private Instant start;
    private long timeElapsed;

    /**
     * Starts the execution of the thread for counting the time.
     */
    @Override
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            start = Instant.now();
            timeElapsed = 0;
            while (true) {
                Instant finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toSeconds();
            }
        }
    }

    @Override
    public String getTimeElapsed() {
        return "I've been running for " + timeElapsed + " seconds";
    }
}
