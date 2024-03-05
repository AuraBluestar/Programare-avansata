package lab2.lab2;

public class Depot {

    private String name;
    private Vehicle[] vehicles;

    public Depot(String name, Vehicle[] vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }
}
