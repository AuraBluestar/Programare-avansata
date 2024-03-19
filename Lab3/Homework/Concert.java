package lab3.lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {

    public double ticketPrice = 0;
    private final LocalTime closing, opening;
    private final LocalDate date;
    private final boolean visitable = true, payable = true;

    private Map<LocalDate, TimeInterval> timetable;

    public Concert(LocalTime closing, LocalTime opening, LocalDate date) {
        this.closing = closing;
        this.opening = opening;
        this.date = date;
    }

    public Concert() {
        this.closing = LocalTime.MAX;
        this.opening = LocalTime.MIN;
        this.date = LocalDate.now();
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
    
    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public void setTicketPrice(double ticket) {
        ticketPrice = ticket;
    }

}
