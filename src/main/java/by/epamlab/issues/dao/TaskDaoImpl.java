package by.epamlab.issues.dao;

import by.epamlab.issues.model.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @SuppressWarnings("unchecked")
    public List<Task> loadTasks() {
        List<Task> tasks = sessionFactory.getCurrentSession()
                .createQuery("from Task")
                .list();
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        sessionFactory.getCurrentSession().saveOrUpdate(task);
    }

    @Override
    public Task getLastTask() {
        Task task = (Task)sessionFactory.getCurrentSession()
                .createQuery("from Task where id = (select max(id) from Task)")
                .uniqueResult();
        return task;
    }

    @Override
    public Task getTaskById(Integer id) {
        Task task = (Task)sessionFactory.getCurrentSession()
                .createQuery("from Task where id = :id")
                .setString("id", String.valueOf(id))
                .uniqueResult();
        return task;
    }

    @Override
    public void deleteTask(Integer id) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from Task where id= :id")
                .setString("id", Integer.toString(id)).executeUpdate();
    }
}
