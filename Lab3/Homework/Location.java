
package lab3.lab3;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Location {

    public abstract String getName();
    public abstract void setName(String name);

    public Location() {
    }

    public abstract boolean isPayable();
    public abstract boolean isVisitable(LocalDate date);
    public abstract LocalTime getOpeningHour(LocalDate date);
    public abstract LocalTime getClosingHour(LocalDate date);
    public abstract void setOpening(LocalTime time);
    public abstract void setClosing(LocalTime time);
}
