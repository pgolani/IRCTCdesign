public class Station {
    private String stationName;
    private String stationCode;
    private int index;

    public Station(String stationName, String stationCode, int index) {
        this.stationName = stationName;
        this.stationCode = stationCode;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
    public String getStationName() {
        return stationName;
    }
}
