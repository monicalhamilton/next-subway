import gtfs.RealtimeAccess;

import java.io.IOException;

public class SubwayApp {
    public static void main(String[] args) throws IOException {
        System.out.println(RealtimeAccess.nextArrivals("R32N"));
        System.out.println(RealtimeAccess.tripUpdates("R"));
    }

}
