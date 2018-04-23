package gtfs;

import com.opencsv.bean.CsvBindByName;

public class Route implements GtfsIdentified {

    @CsvBindByName(column = "route_id")
    private String routeId;
    @CsvBindByName(column = "agency_id")
    private String agencyId;
    @CsvBindByName(column = "route_short_name")
    private String routeShortName;
    @CsvBindByName(column = "route_long_name")
    private String routeLongName;
    @CsvBindByName(column = "route_desc")
    private String routeDescription;
    @CsvBindByName(column = "route_type")
    private String routeType;
    @CsvBindByName(column = "route_url")
    private String routeUrl;
    @CsvBindByName(column = "route_color")
    private String routeColor;
    @CsvBindByName(column = "route_text_color")
    private String routeTextColor;

    public String getRouteId() {
        return routeId;
    }

    @Override
    public String getId() {
        return routeId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public String getRouteDescription() {
        return routeDescription;
    }

    public String getRouteType() {
        return routeType;
    }

    public String getRouteUrl() {
        return routeUrl;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId='" + routeId + '\'' +
                ", agencyId='" + agencyId + '\'' +
                ", routeShortName='" + routeShortName + '\'' +
                ", routeLongName='" + routeLongName + '\'' +
                ", routeDescription='" + routeDescription + '\'' +
                ", routeType='" + routeType + '\'' +
                ", routeUrl='" + routeUrl + '\'' +
                ", routeColor='" + routeColor + '\'' +
                ", routeTextColor='" + routeTextColor + '\'' +
                '}';
    }
}
