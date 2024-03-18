
package lab3.lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Church  extends Location implements Visitable{
    
    private LocalTime closing, opening;
    private LocalDate date;
    private final boolean visitable =true, payable=false;
    private Map<LocalDate, TimeInterval> timetable;
    private String name;
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    
    public void setTimetable(Map<LocalDate, TimeInterval> timetable){
        this.timetable=timetable;
    }

    public Church() {
        this.closing = LocalTime.MAX;
        this.opening=LocalTime.MIN;
        this.date=LocalDate.now();
    }

    @Override
    public LocalTime getOpeningHour(LocalDate date) {
        return opening;
    }

    @Override
    public LocalTime getClosingHour(LocalDate date) {
        return closing;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable(LocalDate date) {
        timetable.put(date, new TimeInterval(opening, closing));
        return timetable;
    }

    public Church(LocalTime closing, LocalTime opening, LocalDate date) {
        this.closing = closing;
        this.opening = opening;
        this.date = date;
    }
    
    public void setClosing(LocalTime closing) {
        this.closing = closing;
    }

    public void setOpening(LocalTime opening) {
        this.opening = opening;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    @Override
    public boolean isPayable() {
        return payable;
    }

    @Override
    public boolean isVisitable(LocalDate date) {
        if(date==this.date)
            return visitable;
        else return false;
    }
}
