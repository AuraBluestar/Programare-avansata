package lab4.lab4;

import java.util.stream.IntStream;

public class Lab4 {

    public static void main(String[] args) {

        var people = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Person(i))
                .toArray(Person[]::new);
        people[1].setRole(Role.DRIVER);
        people[1].setDestination("FII");
        people[0].setRole(Role.PASSENGER);
        people[0].setDestination("FII");
        people[2].setRole(Role.DRIVER);
        people[2].setDestination("Vaslui");
        people[3].setRole(Role.PASSENGER);
        people[3].setDestination("Iasi");
        
        var car = new Carpool();
        car.addPerson(people[0]);
        car.addPerson(people[1]);
        car.addPerson(people[2]);
        car.addPerson(people[3]);
        
        car.getPerson();
        car.setEchipa(); car.getEchipa();
        //car.sortDriver();
    }
}
