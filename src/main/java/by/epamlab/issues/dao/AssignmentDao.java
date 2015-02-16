package by.epamlab.issues.dao;

import by.epamlab.issues.model.Assignment;

import java.util.List;

public interface AssignmentDao {
    List<Assignment> loadAssignments();

    void addAssignment(Assignment assignment);

    /*Assignment getLastAssignment();*/

    Assignment getAssignmentById(Integer id);
}
