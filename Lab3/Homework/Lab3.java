package lab3.lab3;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lab3 {

    public static void main(String[] args) {
        /*Concert concert = new Concert();
        //concert.setTimetable(double bgnTime, double endTime);
        concert.setTicketPrice(20);
        Church church = new Church();
        //church.setClosingHour(LocalTime.MAX);
        System.out.print(church.getClosingHour(LocalDate.now()));
        Statue statue = new Statue();
        statue.setOpening(LocalTime.MIN);
        Trip trip = new Trip("Iasi", LocalDate.MIN, LocalDate.MAX);*/

 //Visitable[] arr = {church, statue, concert};
 
  // Crearea planului de călătorie
        TravelPlan travelPlan = new TravelPlan();

        // Adăugarea vizitelor la planul de călătorie
        Location church = new Church();
        church.setName("St Patrik");
        Location statue = new Statue();
        statue.setName("Stefan cel Mare pe cal");
        Attraction concert = new Concert(LocalTime.of(19, 0), LocalTime.of(22, 0), LocalDate.of(2024, 3, 15));

        LocalDate date1 = LocalDate.of(2024, 3, 15);
        LocalDate date2 = LocalDate.of(2024, 3, 16);

        travelPlan.addVisit(church, date1);
        travelPlan.addVisit(statue, date2);
        //travelPlan.addVisit(concert, date2);

        // Afișarea planului de călătorie
        travelPlan.displayTravelPlan();
 
}
}
