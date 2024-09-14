import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private int id;
    private String name;
    private String email;
    private String phoneNo;
    private List<Ticket> tickets;

    public User( String name, String email, String phoneNo) {
        this.id = UUID.randomUUID().hashCode();
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.tickets = new ArrayList<>();
    }

    public Ticket bookTicket(String ticketType ,Train train , Station source , Station destination , LocalDate travelDate){
        Seat seat = train.getASeat(travelDate , source ,destination);
        if(seat == null) {
            System.out.println("No seat available");
        }
        Ticket ticket = TicketFactory.createTicket(ticketType,train,this,seat,source,destination,travelDate);
        seat.bookSeat(source , destination);
        tickets.add(ticket);
        System.out.println("Ticket booked successfully for seat:" + seat.getSeatNo());
        return ticket;
    }

    public void cancelTicket(Ticket ticket){
        ticket.cancel(); // SRP and Encapsulation
        tickets.remove(ticket);
        System.out.println("Ticket cancelled");
    }

    public List<Ticket> getTickets(){
        return tickets;
    }

}
