package lab2.lab2;

public class Trucks {

    private int capacity;
    private String name;
    private Depot depot;

    public Trucks(String name, int capacity, Depot depot) {
        this.capacity = capacity;
        this.name = name;
        this.depot = depot;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public Depot getDepot() {
        return depot;
    }
}
