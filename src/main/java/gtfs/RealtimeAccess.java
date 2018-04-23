package gtfs;

import com.google.transit.realtime.GtfsRealtime;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RealtimeAccess {

    private static final int FEED_ID_123456S = 1;
    private static final int FEED_ID_ACEHS = 26;
    private static final int FEED_ID_NQRW = 16;
    private static final int FEED_ID_BDFM = 21;
    private static final int FEED_ID_L = 2;
    private static final int FEED_ID_SIR = 11;
    private static final int FEED_ID_G = 31;
    private static final int FEED_ID_JZ = 36;
    private static final int FEED_ID_7 = 51;

    private static final String API_KEY = "bd9ac687cf59159a66985f1d28235316";

    public static List<Arrival> nextArrivals(String stopId, String routeId) throws IOException {
        return getUpdates()
                .filter(tripUpdate -> tripUpdate.getRoute().getId().equals(routeId))
                .map(TripUpdate::getArrivals)
                .flatMap(Collection::stream)
                .filter(arrival -> arrival.getStop().getId().equals(stopId))
                .collect(toList());
    }

    public static List<Arrival> nextArrivals(String stopId) throws IOException {
        return getUpdates()
                .map(TripUpdate::getArrivals)
                .flatMap(Collection::stream)
                .filter(arrival -> arrival.getStop().getId().equals(stopId))
                .collect(toList());
    }

    public static List<TripUpdate> tripUpdates(String routeId) throws IOException {
        return getUpdates()
                .filter(tripUpdate -> tripUpdate.getRoute().getId().equals(routeId))
                .collect(toList());
    }

    private static Stream<TripUpdate> getUpdates() throws IOException {
        return getFeed().getEntityList().stream()
                .filter(GtfsRealtime.FeedEntity::hasTripUpdate)
                .map(GtfsRealtime.FeedEntity::getTripUpdate)
                .map(TripUpdate::fromGtfs);
    }

    private static GtfsRealtime.FeedMessage getFeed() throws IOException {
        URL url = new URL(String.format("http://datamine.mta.info/mta_esi.php?key=%s&feed_id=%s", API_KEY, FEED_ID_NQRW));
        return GtfsRealtime.FeedMessage.parseFrom(url.openStream());
    }
}
