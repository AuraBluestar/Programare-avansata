package lab4.lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//import java.util.TreeSet;

public class Carpool {

    private final LinkedList<Person> drivers;
    private final List<Person> passengers;
    private final Map<Person, Person> echipe = new HashMap<>();
    private final List<Person> persons;

    public Carpool() {
        drivers = new LinkedList<>();
        passengers = new ArrayList<>();
        persons = new ArrayList<>();
    }

    // Method to add a person (driver or passenger) to the system
    public void addPerson(Person person) {
        persons.add(person);
        if (person.getRole() == Role.DRIVER) {
            drivers.add(person);
        } else {
            passengers.add(person);
        }
    }

    public void getPerson() {
        System.out.println("Persoane: ");
        for (Person person : persons) {
            System.out.print("Nume: " + person.getName() + ", Destination: ");
            List<Destination> destinations = person.getDestination(); // Salvăm lista de destinații a persoanei
            for (int i = 0; i < destinations.size(); i++) { // Modificăm condiția pentru a evita IndexOutOfBoundsException
                Destination d = destinations.get(i);
                System.out.print(d.getName());
                if (i < destinations.size() - 1) { // Adăugăm virgulă între destinații, doar dacă nu suntem la ultimul element
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println(" ");
    }

    public void getDriver() {

        System.out.println("Soferi: ");
        int n = drivers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Person person1 = drivers.get(i);
                Person person2 = drivers.get(j);
                if (person1.getAge() < person2.getAge()) {
                    drivers.set(i, person2);
                    drivers.set(j, person1);
                }
            }
        }
        for (Person d : drivers) {
            System.out.println("Nume: " + d.getName() + ", varsta: " + d.getAge());
        }
        System.out.println(" ");
    }

    public void getPassenger() {

        System.out.println("Pasageri: ");
        int n = passengers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Person person1 = passengers.get(i);
                Person person2 = passengers.get(j);
                if (person1.getName().compareTo(person2.getName()) > 0) {
                    passengers.set(i, person2);
                    passengers.set(j, person1);
                }
            }
        }
        for (Person p : passengers) {
            System.out.println("Nume: " + p.getName());
        }
        System.out.println(" ");
    }

    public void setEchipa() {
        for (Person driver : drivers) {
            for (Person passenger : passengers) {
                Destination destinatie = passenger.getDestination().get(0);
                if (driver.getDestination().contains(destinatie)) {
                    echipe.put(driver, passenger);
                }
            }
        }
    }

    public void getEchipa() {
        for (Map.Entry<Person, Person> entry : echipe.entrySet()) {
            Person sofer = entry.getKey();
            Person pasager = entry.getValue();
            System.out.println("Soferul: " + sofer.getName() + " si Pasagerul: " + pasager.getName());
        }
        System.out.println(" ");
    }

    public List<Destination> computeDestinationsForDrivers() {
        return drivers.stream() // Stream de șoferi
                .flatMap(driver -> driver.getDestination().stream()) // Parcurgem driver si luam toate destinatiile
                .distinct() // Eliminăm destinațiile duplicate
                .collect(Collectors.toList()); // Colectăm rezultatul într-o listă
    }

    // Metodă pentru a calcula harta destinațiilor și a persoanelor interesate în ele
    public Map<Destination, List<Person>> computeDestinationMap() {
        Map<Destination, List<Person>> destinationMap = new HashMap<>();
        List<Destination> possibleDestinations = this.computeDestinationsForDrivers();
        for (Destination destination : possibleDestinations) {
            List<Person> interestedPersons = destinationMap.getOrDefault(destination, new ArrayList<>());
            for (Person person : persons) {
                if (destination == person.getDestination()) {
                    interestedPersons.add(person);
                }
            }
            destinationMap.put(destination, interestedPersons);
        }
        return destinationMap;
    }

}
