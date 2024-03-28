package lab5.lab5;

public class Lab5 {

    public static void main(String[] args) {
        Lab5 app = new Lab5();
        app.testRepo();
        app.testLoadView();
    }
    private void testRepo() {
    var repo = new Repository("c:/documents");
    var service = new RepositoryService();
    service.print(repo);
    service.export(repo, "c:/repository.json");
    var doc = repo.findDocument("...");
    service.view(doc);
     }

}
