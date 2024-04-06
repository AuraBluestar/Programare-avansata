package com.company.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    String name;
    List<String> abilities; // Lista de abilități comune cu alte persoane

    public Employee(String name) {
        this.name = name;
        this.abilities = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
}
