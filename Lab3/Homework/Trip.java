package lab3.lab3;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Trip {

    private final String city;
    private final LocalDate beginTrip;
    private final LocalDate endTrip;
    private final List<Location> attractions = new ArrayList<>();

    public Trip(String city, LocalDate beginTrip, LocalDate endTrip) {
        this.city = city;
        this.beginTrip = beginTrip;
        this.endTrip = endTrip;
    }

    public void addAttraction(Location attraction) {
        attractions.add(attraction);
    }

    public void getAttractions(LocalDate date) {
        List<Location> visitableNotPayable = new ArrayList<>();

        // Iterate through attractions
        for (Location attraction : attractions) {
            if (attraction.isVisitable(date) && !attraction.isPayable()) {
                visitableNotPayable.add(attraction);
            }
        }
        // Sort attractions by opening hour
        Collections.sort(visitableNotPayable, (loc1, loc2) -> loc1.getOpeningHour(beginTrip).compareTo(loc2.getOpeningHour(beginTrip)));

        // Display sorted attractions
        System.out.println("Locations that are visitable and not payable, sorted by opening hour:");
        for (Location location : attractions) {
            System.out.println(location.getName() + " - Opening hour: " + location.getOpeningHour(date));
        }
    }
    public String getCity() {
        return city;
    }

    public LocalDate getBeginTrip() {
        return beginTrip;
    }

    public LocalDate getEndTrip() {
        return endTrip;
    }
}
