package lab3.lab3;

public class Attraction implements Comparable<Attraction> {

    private String name;

    /*public Attraction(String name, String Type) {
        this.name = name;
        this.type=type;
    }
*/
    public Attraction() {
    }
    
    
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
