package gtfs;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Routes {

    private static final String DIR = "/google_transit";
    private static final String CSV = "routes.txt";

    public Route findRoute(String id) throws FileNotFoundException {
        String file1 = this.getClass().getResource(DIR + "/" + CSV).getFile();
        List<Route> routes = new CsvToBeanBuilder<Route>(new FileReader(file1))
                .withType(Route.class).build().parse();
        return routes.stream().filter(r -> r.getRouteId().equals(id)).findFirst().orElseThrow(IllegalStateException::new);
    }

}
