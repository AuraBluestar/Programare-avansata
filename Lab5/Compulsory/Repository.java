package lab5.lab5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private String directory;
private Map<Person, List<Document>> documents = new HashMap<>();
public Repository(String directory) {
this.directory = directory;
loadDocuments();
}
private void loadDocuments() {
// Read all sub-directories
// c:/documents/Popescu_1001, ...
// Read all files in the sub-directories
// diploma_bac.pdf, copie_buletin.png, ...
}

}
