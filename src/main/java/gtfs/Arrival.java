package gtfs;

import com.google.transit.realtime.GtfsRealtime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

class Arrival {
    private final Stop stop;
    private final ZonedDateTime arrivalTime;

    private Arrival(String stopId, ZonedDateTime arrivalTime) {
        this.stop = GtfsStatic.STOPS.get(stopId);
        this.arrivalTime = arrivalTime;
    }

    public static Arrival fromGtfs(GtfsRealtime.TripUpdate.StopTimeUpdate update) {
        return new Arrival(update.getStopId(), Instant.ofEpochSecond(update.getArrival().getTime()).atZone(ZoneId.systemDefault()));
    }

    private long getMinutesUntil() {
        return ZonedDateTime.now().until(arrivalTime, ChronoUnit.MINUTES);
    }

    @Override
    public String toString() {
        return "Arrival{" +
                "stop='" + (stop == null ? null : stop.getStopName()) + '\'' +
                ", minutesUntil=" + getMinutesUntil() +
                '}';
    }
}
