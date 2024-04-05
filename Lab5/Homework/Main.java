import com.company.ExecuteCommand;
import com.company.InvalidCommandException;
import com.company.employee.Person;
import com.company.repository.Repository;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidCommandException {
        var main = new Main();
        main.testRepo();
    }

    private void testRepo() throws IOException, InvalidCommandException {
        
        Person employee1 = new Person(1, "John Doe");
        Person employee2 = new Person(2, "Jane Smith");
        var repo = new Repository("c:/documents");
        repo.addEmployeeDirectory(employee1);
        repo.addEmployeeDirectory(employee2);
        repo.loadDocuments();
        
        var com = new ExecuteCommand();
        com.execute("c:/documents","export", "c:/desktop");
        com.execute("c:/repository.json", "view");
    }
    
}