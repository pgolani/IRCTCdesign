import java.time.LocalDate;
import java.util.UUID;

public class GeneralTicket implements Ticket {
    private String  ticketId;
    private Train train;
    private Seat seat;
    private Station source;
    private Station destination;
    private LocalDate date;
    private User userdetails;
    private String status;

    public GeneralTicket(User userdetails , Train train, Seat seat, Station source, Station destination, LocalDate date) {
        this.userdetails = userdetails;
        this.ticketId = UUID.randomUUID().toString();
        this.train = train;
        this.seat = seat;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.status= "Confirmed";
    }

    public void cancel() {
        seat.cancelSeat(source, destination);
        this.status = "Canceled";
    }
    public void printDetails(){
        System.out.println( "Train" + train + "Seat" + seat.getSeatNo() + " Source" + source.getStationName() + " Destination" + destination.getStationName() + " Date" + date);
    }
}
