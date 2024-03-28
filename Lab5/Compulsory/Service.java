package lab5.lab5;

import java.io.File;

public class Service {
    public void export(Repository repo, String path)
 throws IOException {

 ObjectMapper objectMapper = new ObjectMapper();
 objectMapper.writeValue(
 new File(path),
 repo);
 }
 public Repository read(String path)
 throws InvalidCatalogException {
 ObjectMapper objectMapper = new ObjectMapper();
 Repository repo = objectMapper.readValue(
 new File(path),
Repository.class);
 }

}
