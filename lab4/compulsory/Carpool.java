package lab4.lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carpool {

    private final List<Person> drivers;
    private final List<Person> passengers;
    Map<Person, Person> echipe = new HashMap<>();

    public Carpool() {
        drivers = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    // Method to add a person (driver or passenger) to the system
    public void addPerson(Person person) {
        if (person.getRole() == Role.DRIVER) {
            drivers.add(person);
        } else {
            passengers.add(person);
        }
    }

    public void getPerson() {
        for (Person person : drivers) {
            System.out.println("Id: " + person.getId() + ", Destination: " + person.getDestination());
        }
        for (Person person : passengers) {
            System.out.println("Id: " + person.getId() + ", Destination: " + person.getDestination());
        }
    }

    public void setEchipa() {
        for (Person driver : drivers) {
            for (Person passenger : passengers) {
                if (passenger.getDestination().equals(driver.getDestination())) {
                    echipe.put(driver, passenger);
                }
            }
        }
    }

    public void getEchipa() {
        for (Map.Entry<Person, Person> entry : echipe.entrySet()) {
            Person sofer = entry.getKey();
            Person pasager = entry.getValue();
            System.out.println("Soferul: " + sofer.getId() + " si Pasagerul: " + pasager.getId());
        }
        System.out.println(" ");
    }
}
