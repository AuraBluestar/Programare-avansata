package lab3.lab3;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lab3 {

    public static void main(String[] args) {
        Concert concert = new Concert();
        //concert.setTimetable(double bgnTime, double endTime);
        concert.setTicketPrice(20);
        Church church = new Church();
        church.setTimetable(LocalTime.MIN, LocalTime.MAX);
        System.out.print(church.getClosingHour(LocalDate.MAX));
        Statue statue = new Statue();
        statue.setOpening(LocalTime.MIN);
        Trip trip = new Trip("Iasi", LocalDate.MIN, LocalDate.MAX);

 //Visitable[] arr = {church, statue, concert};
}
}
