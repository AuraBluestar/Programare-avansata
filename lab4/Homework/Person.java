package lab4.lab4;

import java.util.ArrayList;
import java.util.List;

public class Person{

    private final int id;
    private String name;
    private int age;
    private List<Destination> destination = new ArrayList<>();
    private Role role;

    public Person(int id, Destination destination, Role role) {
       this.id = id;
       this.destination.add(destination);
       this.role = role;
    }

    public Person(int id) {
        this.id = id;
        this.age = 18;
        this.role = Role.PASSENGER;
    }

    public void setDestination(Destination destination) {
        if(this.role==Role.DRIVER)
            this.destination.add(destination);
        else{
            this.destination=new ArrayList<>();
            this.destination.add(destination);
        }
    }

    public void setRole(Role role) {
        if ((role == Role.DRIVER && age >= 18) || role == Role.PASSENGER) {
            this.role = role;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public List<Destination> getDestination() {
        return destination;
    }

    public Role getRole() {
        return role;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
