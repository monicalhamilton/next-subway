package gtfs;

import com.google.transit.realtime.GtfsRealtime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

class Arrival {
    private Stop stop;
    private ZonedDateTime arrivalTime;

    public Arrival() {
        stop = null;
        arrivalTime = null;
    }

    private Arrival(String stopId, ZonedDateTime arrivalTime) {
        this.stop = GtfsStatic.STOPS.getOrDefault(stopId, Stop.fromUnknown(stopId));
        this.arrivalTime = arrivalTime;
    }

    public static Arrival fromGtfs(GtfsRealtime.TripUpdate.StopTimeUpdate update) {
        return new Arrival(update.getStopId(), Instant.ofEpochSecond(update.getArrival().getTime()).atZone(ZoneId.systemDefault()));
    }

    public Stop getStop() {
        return stop;
    }

    public ZonedDateTime getArrivalTime() {
        return arrivalTime;
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
