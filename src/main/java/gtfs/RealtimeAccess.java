package gtfs;

import com.google.transit.realtime.GtfsRealtime;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

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

    public static List<Arrival> nextArrivals(String stopId) throws IOException {
        return getFeed().getEntityList().stream()
                .filter(GtfsRealtime.FeedEntity::hasTripUpdate)
                .map(GtfsRealtime.FeedEntity::getTripUpdate)
                .map(GtfsRealtime.TripUpdate::getStopTimeUpdateList)
                .flatMap(Collection::stream)
                .filter(stopTimeUpdate -> stopTimeUpdate.getStopId().equals(stopId))
                .map(Arrival::fromGtfs)
                .collect(toList());

    }
    public static List<TripUpdate> tripUpdates(String routeId) throws IOException {
        return getFeed().getEntityList().stream()
                .filter(GtfsRealtime.FeedEntity::hasTripUpdate)
                .map(GtfsRealtime.FeedEntity::getTripUpdate)
                .filter(tripUpdate -> tripUpdate.getTrip().getRouteId().equals(routeId))
                .map(TripUpdate::fromGtfs)
                .collect(toList());
    }

    private static GtfsRealtime.FeedMessage getFeed() throws IOException {
        URL url = new URL(String.format("http://datamine.mta.info/mta_esi.php?key=%s&feed_id=%s", API_KEY, FEED_ID_NQRW));
        return GtfsRealtime.FeedMessage.parseFrom(url.openStream());
    }
}
