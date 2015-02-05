package by.epamlab.projects.dao;

import by.epamlab.projects.model.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> getProjects() {
        List<Project> projects;
        projects = sessionFactory.getCurrentSession()
                .createQuery("from Project")
                .list();
        return projects;
    }

    @Override
    public void addProject(Project project) {
        sessionFactory.getCurrentSession().save(project);
    }

    @Override
    public void deleteProject(Integer id) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from Project where id= :id")
                .setString("id", Integer.toString(id)).executeUpdate();
    }
}
