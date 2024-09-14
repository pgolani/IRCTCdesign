import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainScheduleManager {

    private static TrainScheduleManager instance;

    private Map<String , Train> trainMap;

    private TrainScheduleManager() {
         trainMap = new HashMap<>();
    }

    public static TrainScheduleManager getInstance() {
        if(instance == null) {
            synchronized (TrainScheduleManager.class) {
                if (instance == null) {
                    instance = new TrainScheduleManager();
                }
            }
        }
        return instance;

    }

    public void addTrain(Train train) {
        trainMap.put(train.getTrainNo(), train);
    }

    public List<Train> searchTrains(Station source , Station destination) {
        List<Train> availableTrains = new ArrayList<>();
        for(Train train : trainMap.values()) {
            if(train.getSource().equals(source) && train.getDestination().equals(destination)) {
                availableTrains.add(train);
            }
        }
        return availableTrains;
    }


}
