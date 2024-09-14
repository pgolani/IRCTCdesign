import java.time.LocalDate;

//Factory Design Pattern

public class TicketFactory {

    public static Ticket createTicket(String type , Train train , User user , Seat seat , Station source , Station destination , LocalDate date) {

        switch (type){
            case "General":
                new GeneralTicket(user ,train,seat,source,destination,date);
            case "Tatkal" :
                new TatkalTicket(user ,train,seat,source,destination,date);
            default:
                throw new IllegalArgumentException("Ticket type not recognized");
        }

    }
}
