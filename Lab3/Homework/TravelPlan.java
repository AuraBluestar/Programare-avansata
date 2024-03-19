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

    public void displayTravelPlan() {
        System.out.println("Travel Plan: ");
        //System.out.println(" ");
        int day = 1;
        LocalDate data = LocalDate.of(2000, 1, 1);
        for (Map.Entry<Location, LocalDate> entry : plan.entrySet()) {
            Location location = entry.getKey();
            LocalDate date = entry.getValue();
            if (data == date) {
                System.out.println("Location: " + location.getName());
            } else {
                System.out.println("Day " + day + ", Date: " + date);
                System.out.println("Location: " + location.getName());
                data = date;
                day++;
            }

        }
        System.out.println(" ");
    }
    
}
