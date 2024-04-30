package lab4.lab4;

public class Person {

    private int id, age;
    private String destination;
    private Role role;

    public Person(int id, String destination, Role role) {
        this.id = id;
        this.destination = destination;
        this.role = role;
    }

    public Person(int id) {
        this.id = id;
        this.age = 18;
        this.role = Role.PASSENGER;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public String getDestination() {
        return destination;
    }

    public Role getRole() {
        return role;
    }

}
