package gtfs;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

class GtfsStaticLoader {

    private static final String DIR = "/google_transit";

    <T extends GtfsIdentified> Collection<T> parseData(Class<T> clazz, String filename) throws IOException {
        String file = this.getClass().getResource(DIR + "/" + filename).getFile();
        FileReader fileReader = new FileReader(file);
        return new CsvToBeanBuilder<T>(fileReader)
                .withType(clazz).build().parse();
    }
}
