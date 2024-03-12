
package lab3.lab3;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Trip {

    private String city;
    private LocalDate beginTrip, endTrip;
    private List<Location> attractions = new ArrayList<>();

    public Trip(String city, LocalDate beginTrip, LocalDate endTrip) {
        this.city = city;
        this.beginTrip = beginTrip;
        this.endTrip = endTrip;
    }
}
