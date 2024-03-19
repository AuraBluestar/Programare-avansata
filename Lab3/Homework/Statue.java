package lab3.lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Statue extends Location implements Visitable {

    public LocalTime opening;
    public LocalTime closing;
    public LocalDate date;
    private final boolean visitable =true;
    private final boolean payable=false;
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }
    Map<LocalDate, TimeInterval> timetable;

    public Statue() {
        this.opening = LocalTime.MIN;
        this.closing = LocalTime.MAX;
        this.date=LocalDate.now();
    }

    public Statue(LocalTime opening, LocalTime closing, LocalDate date) {
        this.opening = opening;
        this.closing = closing;
        this.date = date;
    }

    @Override
    public void setOpening(LocalTime opening) {
        this.opening = opening;
    }

    @Override
    public void setClosing(LocalTime closing) {
        this.closing = closing;
    }

    @Override
    public LocalTime getOpeningHour(LocalDate date) {
        return LocalTime.MIN;
    }

    @Override
    public LocalTime getClosingHour(LocalDate date) {
        return LocalTime.MAX;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable(LocalDate date) {
        
        timetable.put(date, new TimeInterval(opening, closing));
        return timetable;
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

    @Override
    public String getName() {
         return name;
    }
}
