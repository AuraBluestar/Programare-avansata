package lab3.lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Statue extends Location implements Visitable {

    public LocalTime opening;
    public LocalTime closing;

    public Statue() 
    { 
        this.opening = LocalTime.MIN;
        this.closing = LocalTime.MAX;
    }

    public void setOpening(LocalTime opening) {
        this.opening = opening;
    }

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
    public Map<LocalDate, TimeInterval> getTimetable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
