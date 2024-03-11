package lab2.lab2;
import java.util.Objects;
import java.time.LocalTime;

public class Client {

    private String name;
    private LocalTime minTime, maxTime;
    private Type tip;

    public Client(String nume, LocalTime mTime, LocalTime maxTime, Type t) {
        this.name = nume;
        this.minTime = mTime;
        this.maxTime = maxTime;
        this.tip = t;
    }

    public String getName() {
        return this.name;
    }

    ;
    public LocalTime getMinTime() {
        return this.minTime;
    }

    public LocalTime getMaxTime() {
        return this.maxTime;
    }

    public Type getTip() {
        return this.tip;
    }

    public Client() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    public void setTip(Type tip) {
        this.tip = tip;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj instanceof Client) return false;
        Client client = (Client) obj;
        if (client.getName().equals(this.name))
            return false;
        else return true;
    }
    // Implementarea metodei hashCode pentru a fi consistentă cu metoda equals
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
