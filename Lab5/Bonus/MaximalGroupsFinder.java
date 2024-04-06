package com.company.document;

import com.company.person.Employee;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximalGroupsFinder {
    public List<Set<Employee>> findMaximalGroups(AbilityGraph graph) {
        List<Set<Employee>> groups = new ArrayList<>();
        Set<Employee> visited = new HashSet<>();

        for (Employee employee : graph.adjacencyList.keySet()) {
            if (!visited.contains(employee)) {
                Set<Employee> currentGroup = new HashSet<>();
                DFS(graph, employee, visited, currentGroup);
                groups.add(currentGroup);
            }
        }

        return groups;
    }

    private void DFS(AbilityGraph graph, Employee employee, Set<Employee> visited, Set<Employee> currentGroup) {
        visited.add(employee);
        currentGroup.add(employee);

        for (Employee neighbor : graph.getAdjacentEmployees(employee)) {
            if (!visited.contains(neighbor)) {
                DFS(graph, neighbor, visited, currentGroup);
            }
        }
    }
}

