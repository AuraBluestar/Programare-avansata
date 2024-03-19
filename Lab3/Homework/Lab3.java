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

        
        
        
        TravelPlan travelPlan = new TravelPlan();

        Location church = new Church();
        church.setName("Catedrala St Patrik");
        Location statue = new Statue();
        statue.setName("statuia lui Stefan cel Mare pe cal");
        Location monument = new Statue();
        monument.setName("Ateneul Roman");

        LocalDate date1 = LocalDate.of(2024, 3, 15);
        LocalDate date2 = LocalDate.of(2024, 3, 16);  
        church.setOpening(LocalTime.of(10,52,06));
        monument.setOpening(LocalTime.of(8, 0));

        travelPlan.addVisit(church, date1);
        travelPlan.addVisit(statue, date2);
        travelPlan.addVisit(monument, date2);

        travelPlan.displayTravelPlan();
 
}
}
