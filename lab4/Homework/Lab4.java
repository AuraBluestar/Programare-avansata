package lab4.lab4;
import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.List;

public class Lab4 {

    public static void main(String[] args) {

        Faker faker = new Faker(new Locale("en")); // Specificăm limba pentru generarea de nume false

        // Generăm persoane cu nume false aleatorii
        Person[] people = new Person[4];
        for (int i = 0; i < 4; i++) {
            people[i] = new Person(i);
            people[i].setName(faker.name().fullName());
        }

        // Generăm destinații cu nume false aleatorii
        Destination d1 = new Destination(faker.address().cityName());
        Destination d2 = new Destination(faker.address().cityName());

        // Setăm roluri, destinații și alte informații pentru persoane
        people[1].setRole(Role.DRIVER);
        people[1].setDestination(d1);
        people[1].setDestination(d2);
        people[1].setAge(faker.number().numberBetween(18, 60)); // Generăm vârste aleatorii între 18 și 60 de ani

        people[0].setRole(Role.PASSENGER);
        people[0].setDestination(d2);

        people[2].setRole(Role.DRIVER);
        people[2].setDestination(d1);
        people[2].setAge(faker.number().numberBetween(18, 60));

        people[3].setRole(Role.PASSENGER);
        people[3].setDestination(d2);

        var car = new Carpool();
        car.addPerson(people[0]);
        car.addPerson(people[1]);
        car.addPerson(people[2]);
        car.addPerson(people[3]);

        car.getPerson();
        car.setEchipa();
        car.getDriver();
        car.getPassenger();
        car.getEchipa();

        List<Destination> destinationsForDrivers;
        destinationsForDrivers = car.computeDestinationsForDrivers();

        // Afisam lista de destinatii pentru soferi
        System.out.println("Destinatii pentru soferi:");
        for (Destination destination : destinationsForDrivers) {
            System.out.println(destination.getName());
        }

        
        
        
        
    }
}
