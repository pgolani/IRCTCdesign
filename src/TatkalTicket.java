import java.time.LocalDate;
import java.util.UUID;

public class TatkalTicket {
    private String ticketId;
    private Train train;
    private Seat seat;
    private Station source;
    private Station destination;
    private LocalDate date;
    private User userDetails;
    private String status;

    public TatkalTicket(User userDetails , Train train, Seat seat, Station source, Station destination, LocalDate date) {
        this.userDetails = userDetails;
        this.ticketId= UUID.randomUUID().toString();
        this.train = train;
        this.seat = seat;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.status ="Confirmed";
    }

    public void cancel(){
        this.status="Canceled";
        seat.cancelSeat(source, destination);
    }
}
