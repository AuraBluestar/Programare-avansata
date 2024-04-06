package com.company.repository;
import java.io.File;
import com.company.person.Person;
import com.company.document.Document;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;

public class Repository implements Serializable {

    private Person person;
    private final String path;
    private Map<Person, List<Document>> documents = new HashMap<>();
    private List<Document> items = new ArrayList<>();

    public Repository(Person name, String path) {
        this.path = path;
        this.person=name;
        loadDocuments();
    }

    public Repository(String path) {
        this.path = path;
        loadDocuments();
    }

    public final void loadDocuments() {
        File mainDirectory = new File(path);
        // Verificam daca directorul dat exista
        if (!mainDirectory.exists() || !mainDirectory.isDirectory()) {
            System.out.println("Directorul principal nu exista sau nu este un director valid.");
            return;
        }
        // Parcurgem toate subdirectoarele
        File[] subDirectories = mainDirectory.listFiles(File::isDirectory);
        if (subDirectories != null) {
            for (File subDirectory : subDirectories) {
                // Parcurge toate fisierele din subdirector
                File[] files = subDirectory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        //punem intr-un string tipul fisierului
                        String extension = FilenameUtils.getExtension(file.getName());
                        //creem un nou document si il adaugam la lista
                        var d = new Document(file.getName(), extension);
                        items.add(d);
                    }
                }
            }
        }
        documents.put(person, items);
    }

    public String getPath() {
        return path;
    }

    public void setItems(List<Document> items) {
        this.items = items;
    }
    public Map<Person, List<Document>> getDocuments() {
        return documents;
    }

    public void addEmployeeDirectory(Person person) {
        documents = new HashMap<>();
        documents.put(person, new ArrayList<>());
    }
}

