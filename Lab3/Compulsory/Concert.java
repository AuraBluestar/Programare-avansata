package lab3.lab3;

import java.time.LocalDate;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {

    public double ticketPrice = 0;
    private Map<LocalDate, TimeInterval> timetable;

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    /*public void setTimetable(Map<LocalDate, TimeInterval>) {
        this.timetable = timetable;
    }*/
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public void setTicketPrice(double ticket) {
        ticketPrice = ticket;
    }

}
