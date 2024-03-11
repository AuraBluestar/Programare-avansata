package lab2.lab2;

import java.util.Arrays;

public class Problem extends Depot {

    private Depot[] depot = new Depot[1000];
    private int countDepot = 0, countVehicles=0;

    public Problem(String name, Vehicle vehicles) {
        Depot d = new Depot(name, vehicles);
        depot[countDepot++] = d;
    }

    @Override
    public Vehicle[] getVehicles() {
        Vehicle[] masini = new Vehicle[1000];
        Vehicle[] vehicles = new Vehicle[9999];
        for (int i = 0; i <= countDepot; i++) {
            masini = depot[i].getVehicles();
            for(int j=0; j<=masini.length(); j++)
                vehicles[countVehicles++]=masini[j];
        }
        return masini;
    }
}
