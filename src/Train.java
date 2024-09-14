import java.time.LocalDate;
import java.util.*;

public class Train {
    private String trainNo;
    private String trainName;
    private Station source;
    private Station destination;
    private Map<LocalDate, List<Seat>> seatAvailaibilityOnDate;
    private List<Station> route;

    public Train(String trainNo , String trainName , Station source , Station destination , List<Station> stations, int noOfSeats){
        this.trainNo= trainNo;
        this.trainName= trainName;
        this.source= source;
        this.destination= destination;
        this.seatAvailaibilityOnDate = new HashMap<>();
        this.route = stations;

        Calendar calendar = Calendar.getInstance();
        LocalDate today = LocalDate.now();
        for(int i=0 ; i<30;i++){
//            calendar.add(Calendar.DAY_OF_MONTH, 1);
            LocalDate futureDate = today.plusDays(i);
            seatAvailaibilityOnDate.put(futureDate, createSeats(noOfSeats));
        }
    }

    public String getTrainNo() {
        return trainNo;
    }
    public Station getSource() {
        return source;
    }
    public Station getDestination() {
        return destination;
    }

    public List<Seat> createSeats(int noOfSeats){
        List<Seat> seats = new ArrayList<>();
        for (int i=0 ; i<noOfSeats;i++){
            seats.add(new Seat(i ,route.size()));
        }
        return seats;
    }


    public synchronized Seat getASeat(LocalDate date , Station source , Station destination){

        List<Seat> seats= seatAvailaibilityOnDate.get(date);
//        for(Seat seat : seats){
//            System.out.println(seat.getSeatNo());
//        }

        if(seats!=null){
            for(Seat seat : seats){
                if(seat.isSeatAvailable(source,destination)){
                    return seat;
                }
            }
        }
        return null;
    }
}
