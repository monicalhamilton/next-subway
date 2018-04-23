package gtfs;

import com.google.transit.realtime.GtfsRealtime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

class TripUpdate {
    private final Route route;
    private final Collection<Arrival> arrivals;

    private TripUpdate(String routeId, Collection<Arrival> arrivals) {
        this.route = GtfsStatic.ROUTES.get(routeId);
        this.arrivals = arrivals;
    }

    public static TripUpdate fromGtfs(GtfsRealtime.TripUpdate update) {
        return new TripUpdate(update.getTrip().getRouteId(),
                update.getStopTimeUpdateList().stream().map(Arrival::fromGtfs).collect(toList()));
    }

    @Override
    public String toString() {
        return "TripUpdate{" +
                "route=" + route.getRouteShortName() +
                ", arrivals=" + arrivals +
                '}';
    }
}
