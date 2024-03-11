package lab2.lab2;

import java.util.Objects;

public class Depot {

    private String name;
    protected Vehicle[] vehicles;
    private int length = 0;

    public Depot(String name, Vehicle vehicles) {
        this.name = name;
        this.vehicles[length] = vehicles;
        length++;
    }

    public Depot(String name) {
        this.name = name;
    }

    public Depot() {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Depot)) {
            return false;
        }
        Depot depot = (Depot) obj;
        if (depot.getName().equals(this.name))
            return false;
        else return true;
    }

    // Implementarea metodei hashCode pentru a fi consistentă cu metoda equals
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
