package com.company.document;

import com.company.person.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbilityGraph {
    Map<Employee, List<Employee>> adjacencyList; // Lista de adiacenta a grafului

    public AbilityGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(Employee employee1, Employee employee2) {
        adjacencyList.computeIfAbsent(employee1, k -> new ArrayList<>()).add(employee2);
        adjacencyList.computeIfAbsent(employee2, k -> new ArrayList<>()).add(employee1);
    }

    public List<Employee> getAdjacentEmployees(Employee employee) {
        return adjacencyList.getOrDefault(employee, Collections.emptyList());
    }
}
