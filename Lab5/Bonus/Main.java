import com.company.command.ExecuteCommand;
import com.company.document.AbilityGraph;
import com.company.document.MaximalGroupsFinder;
import com.company.exception.InvalidCommandException;
import com.company.person.Employee;
import com.company.person.Person;
import com.company.repository.Repository;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException, InvalidCommandException {
        var main = new Main();
        main.testRepo();
        main.testExcel();
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
    
    private void testExcel(){
        Employee employee1 = new Employee("John");
        Employee employee2 = new Employee("Alice");
        Employee employee3 = new Employee("Bob");
        Employee employee4 = new Employee("Jane");

        AbilityGraph graph = new AbilityGraph();
        graph.addEdge(employee1, employee2);
        graph.addEdge(employee2, employee3);
        graph.addEdge(employee3, employee4);

        MaximalGroupsFinder finder = new MaximalGroupsFinder();
        List<Set<Employee>> maximalGroups = finder.findMaximalGroups(graph);

        for (Set<Employee> group : maximalGroups) {
            System.out.println("Maximal group: " + group);
        }
    }
    
}