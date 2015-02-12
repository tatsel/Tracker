package by.epamlab.issues.dao;

import by.epamlab.issues.model.Assignment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssignmentDaoImpl implements AssignmentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Assignment> loadAssignments() {
        List<Assignment> assignments = sessionFactory.getCurrentSession()
                .createQuery("from Assignment ")
                .list();
        return assignments;
    }

    @Override
    public void addAssignment(Assignment assignment) {
        sessionFactory.getCurrentSession().save(assignment);
    }

    @Override
    public Assignment getLastAssignment() {
        Assignment assignment = (Assignment)sessionFactory.getCurrentSession()
                .createQuery("from Assignment where id = (select max(id) from Assignment)")
                .uniqueResult();
        return assignment;
    }

    @Override
    public Assignment getAssignmentById(Integer id) {
        Assignment assignment = (Assignment) sessionFactory.getCurrentSession()
                .createQuery("from Assignment where id = :id")
                .setString("id", Integer.toString(id))
                .uniqueResult();
        return assignment;
    }
}
