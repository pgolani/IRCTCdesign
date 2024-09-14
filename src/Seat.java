import java.lang.reflect.Array;
import java.util.Arrays;

public class Seat {
    private int seatNo;

    private boolean[] availability;

    public Seat(int seatNo , int totalNoStations){
        this.seatNo = seatNo;
        this.availability = new boolean[totalNoStations];
        Arrays.fill(availability, true);
    }
    public int getSeatNo() {
        return seatNo;
    }

    public synchronized boolean isSeatAvailable(Station from , Station to){
        for(int i = from.getIndex(); i<= to.getIndex(); i++){
            if(!availability[i]){
                return false;
            }
        }
        return true;
    }

    public synchronized void bookSeat(Station from, Station to){
        for(int i = from.getIndex(); i<= to.getIndex(); i++){
            availability[i] = false;
        }
    }

    public void cancelSeat(Station from, Station to){
        for(int i = from.getIndex(); i<= to.getIndex(); i++){
            availability[i] = true;
        }
    }
}
