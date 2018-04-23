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
    // "stop_url"
    @CsvBindByName(column = "location_type")
    private String locationType;
    @CsvBindByName(column = "parent_station")
    private String parentStation;

    public Stop() {
    }

    public Stop(String stopId, String stopName, double stopLatitude, double stopLongitude, String locationType, String parentStation) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.stopLatitude = stopLatitude;
        this.stopLongitude = stopLongitude;
        this.locationType = locationType;
        this.parentStation = parentStation;
    }

    public static Stop fromUnknown(String stopId) {
        return new Stop(stopId, "UNKNOWN", -1, -1, "UNKNOWN", null);
    }

    @Override
    public String getId() {
        return stopId;
    }

    public String getStopId() {
        return stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public double getStopLatitude() {
        return stopLatitude;
    }

    public double getStopLongitude() {
        return stopLongitude;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getParentStation() {
        return parentStation;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId='" + stopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", stopLatitude=" + stopLatitude +
                ", stopLongitude=" + stopLongitude +
                ", locationType='" + locationType + '\'' +
                ", parentStation='" + parentStation + '\'' +
                '}';
    }
}
