package gtfs;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class GtfsStatic {
    public static final Map<String, Route> ROUTES;
    public static final Map<String, Stop> STOPS;

    static {
        try {
            ROUTES = loadData(Route.class, "routes.txt");
            STOPS = loadData(Stop.class, "stops.txt");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static <T extends GtfsIdentified> Map<String, T> loadData(Class<T> clazz, String filename) throws IOException {
        Collection<T> data = new GtfsStaticLoader().parseData(clazz, filename);
        return data.stream().collect(toMap(GtfsIdentified::getId, d -> d));
    }
}
