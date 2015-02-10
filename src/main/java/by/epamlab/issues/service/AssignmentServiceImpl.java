package by.epamlab.issues.service;

import by.epamlab.issues.dao.AssignmentDao;
import by.epamlab.issues.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    private AssignmentDao assignmentDao;
    @Override
    public List<Assignment> loadAssignmentsList() {
        return assignmentDao.loadAssignments();
    }

    @Override
    public void addAssignment(Assignment assignment) {
        assignmentDao.addAssignment(assignment);
    }

    @Override
    public Assignment getLastAssignment() {
        return assignmentDao.getLastAssignment();
    }
}
