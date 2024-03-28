package lab5.lab5;

public record Person() {
var p = new Person(1001, "Popescu"); //generated constructor
System.out.println(p); //toString implementation
System.out.println(p.name()); //accesor methods
}
