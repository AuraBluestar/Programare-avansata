
package lab3.lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Church  extends Location implements Visitable{
    
    private LocalTime closingTime, openingTime;
    public void setTimetable(LocalTime bgnTime, LocalTime endTime){
        openingTime=bgnTime;
        closingTime=endTime;
    }

    public Church() {
        this.closingTime = LocalTime.MAX;
        this.openingTime=LocalTime.MIN;
    }

    @Override
    public LocalTime getOpeningHour(LocalDate date) {
        return openingTime;
    }

    @Override
    public LocalTime getClosingHour(LocalDate date) {
        return closingTime;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
