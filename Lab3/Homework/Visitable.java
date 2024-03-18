package lab3.lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {

    Map<LocalDate, TimeInterval> getTimetable( LocalDate date);
    
    default LocalTime getOpeningHour (LocalDate date) {
        Map<LocalDate, TimeInterval> timetable = getTimetable(date);
        TimeInterval timeInterval = timetable.get(date);
        if (timeInterval != null) {
            return timeInterval.getOpening();
        }
        return LocalTime.MIN;
    }
    
    default LocalTime getClosingHour (LocalDate date) {
        Map<LocalDate, TimeInterval> timetable = getTimetable(date);
        TimeInterval timeInterval = timetable.get(date);
        if (timeInterval != null) {
            return timeInterval.getClosing();
        }
        return LocalTime.MAX;
    }
}
