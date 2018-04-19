import com.google.transit.realtime.GtfsRealtime;
import com.google.transit.realtime.NyctSubway;
import gtfs.Routes;

import java.io.IOException;
import java.net.URL;

public class SubwayApp {

    public static void main(String[] args) throws IOException {

        URL url = new URL("http://datamine.mta.info/mta_esi.php?key=bd9ac687cf59159a66985f1d28235316");
        NyctSubway.NyctFeedHeader nyctFeedHeader = NyctSubway.NyctFeedHeader.parseFrom(url.openStream());
        //System.out.println(nyctFeedHeader);

        GtfsRealtime.FeedMessage message = GtfsRealtime.FeedMessage.parseFrom(url.openStream());
        //System.out.println(message);
        //System.out.println(message.getEntityList().get(0).getTripUpdate());

        NyctSubway.NyctStopTimeUpdate update = NyctSubway.NyctStopTimeUpdate.parseFrom(url.openStream());
        //System.out.println(update);


        GtfsRealtime.TripDescriptor trip = message.getEntityList().get(0).getTripUpdate().getTrip();
        System.out.println(trip);
        System.out.println(new Routes().findRoute(trip.getRouteId()));
    }

}
