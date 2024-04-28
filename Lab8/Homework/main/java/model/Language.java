package model;

import java.util.logging.Logger;

public class Language {

    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Language(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Language() {
    }
    
    @Override
    public String toString() {
        return "Language{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
