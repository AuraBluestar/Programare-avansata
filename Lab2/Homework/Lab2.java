package lab2.lab2;
import java.time.LocalTime;
public class Lab2 {

    public static void main(String[] args) {
        Client c1 = new Client();
        c1.setName("Client 1");
        c1.setMinTime(LocalTime.of(8, 0));
        c1.setMaxTime(LocalTime.of(12, 30));
        c1.setTip(Type.PREMIUM);
        //Vehicle v1=new Vehicle("BMW");
        Depot d1 = new Depot("IasiAuto");
        Trucks t1=new Trucks("BMW", 45, d1);
        System.out.print("Nume client: ");
        System.out.println(c1.getName());
        System.out.print("Tip: ");
        System.out.println(c1.getTip());
        System.out.println(t1.getCapacity());
    }
}
