package gtfs;

import com.opencsv.bean.CsvBindByName;

public class Stop implements GtfsIdentified {
    // stop_id,stop_code,stop_name,stop_desc,stop_lat,stop_lon,zone_id,stop_url,location_type,parent_station
    @CsvBindByName(column = "stop_id")
    private String stopId;
    // "stop_code"
    @CsvBindByName(column = "stop_name")
    private String stopName;
    // "stop_desc"
    @CsvBindByName(column = "stop_lat")
    private double stopLatitude;
    @CsvBindByName(column = "stop_lon")
    private double stopLongitude;
    // "zone_id"
    @CsvBindByName(column = "stop_url")
    private String stopUrl;
    @CsvBindByName(column = "location_type")
    private String locationType;
    @CsvBindByName(column = "parent_station")
    private String parentStation;

    @Override
    public String getId() {
        return stopId;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId='" + stopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", stopLatitude=" + stopLatitude +
                ", stopLongitude=" + stopLongitude +
                ", stopUrl='" + stopUrl + '\'' +
                ", locationType='" + locationType + '\'' +
                ", parentStation='" + parentStation + '\'' +
                '}';
    }
}
