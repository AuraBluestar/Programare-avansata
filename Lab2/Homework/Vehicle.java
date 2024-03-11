package lab2.lab2;
import java.util.Objects;

abstract class Vehicle {

    private String name;
    private Depot depot;

    public Vehicle() {
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract void setDepot(Depot depot);

    public abstract Depot getDepot();
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Depot)) {
            return false;
        }
        Vehicle vehicul = (Vehicle) obj;
        if (vehicul.getName().equals(this.name))
            return false;
        else return true;
    }

    // Implementarea metodei hashCode pentru a fi consistentă cu metoda equals
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
