package lab2.lab2;

public class Vehicle {

    private String name;
    private Depot depot;
    public Vehicle(String nume){
        this.name=nume;
    }
    public String getName(Vehicle v){
        return v.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Depot getDepot() {
        return depot;
    }
    
}
