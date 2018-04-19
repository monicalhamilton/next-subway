package csv;

import com.opencsv.bean.CsvToBeanBuilder;
import gtfs.Route;
import gtfs.Routes;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvLoader {
/*
    private static final String DIR = "/google_transit";

    public <T> void load() throws IOException {
        String file = this.getClass().getResource(DIR + "/routes.txt").getFile();
        try (FileReader reader = new FileReader(file);
             CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())
        ) {
            for (final CSVRecord record : parser) {
                System.out.println(record.get("route_id"));
            }
        }


    }
    */
}
