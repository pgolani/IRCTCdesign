import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) {
            Station station1 = new Station("Station1", "1",0);
            Station station2 = new Station("Station2", "2",1);
            Station station3 = new Station("Station3", "3",2);

            List<Station> trainRoute = Arrays.asList(station1, station2, station3);
            Train train = new Train("123","Ajmer Express",station1,station3 , trainRoute , 30);

            User user1 = new User("Piyush", "p@gmial" , "987");
            User user2 = new User("Sarthak", "s@gmial" , "9875");

            TrainScheduleManager trainScheduleManager = TrainScheduleManager.getInstance();
            trainScheduleManager.addTrain(train);


//            Calendar calendar = Calendar.getInstance();
//            calendar.add(Calendar.DAY_OF_MONTH, 2);

        LocalDate travelDate = LocalDate.now().plusDays(1);
//            Date travelDate = calendar.getTime();

            user1.bookTicket("General", train,station1,station2,travelDate);
            user2.bookTicket("Tatkal", train,station2,station3,travelDate);

//            for(Ticket ticket : user1.getTickets()) {
//                ticket.printDetails();
//            }

            Ticket ticket = user2.getTickets().get(0);

            user1.cancelTicket(ticket);


    }

}
