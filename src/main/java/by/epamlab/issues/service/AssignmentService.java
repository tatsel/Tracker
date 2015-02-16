package by.epamlab.issues.service;

import by.epamlab.issues.model.Assignment;

import java.util.List;

public interface AssignmentService {
    List<Assignment> loadAssignmentsList();

    void addAssignment(Assignment assignment);

   // Assignment getLastAssignment();

    Assignment getAssignmentById(Integer id);
}
