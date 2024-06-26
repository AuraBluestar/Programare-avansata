package lab3.lab3;

import java.time.LocalDate;

public abstract class Attraction implements Comparable<Attraction> {

    private String name;

    public Attraction() {
    }

    public abstract boolean isPayable();

    public abstract boolean isVisitable(LocalDate date);

    @Override
    public int compareTo(Attraction other) {
        //if(name==null)
        return this.name.compareTo(other.name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
