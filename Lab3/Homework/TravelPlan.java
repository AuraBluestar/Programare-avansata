package lab3.lab3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TravelPlan {

    private final Map<Location, LocalDate> plan;
    

    public TravelPlan() {
        this.plan = new HashMap<>();
    }

    public void addVisit(Location location, LocalDate date) {
        plan.put(location, date);
    }

    /*public void addVisit(Attraction attraction, LocalDate date) {
        plan.put(location, date);
    }*/
    
    public void displayTravelPlan() {
        System.out.println("Travel Plan:");
        for (Map.Entry<Location, LocalDate> entry : plan.entrySet()) {
            Location location = entry.getKey();
            LocalDate date = entry.getValue();
            System.out.println("Date: " + date + ", Location: " + location.getName());
        }
    }
}
