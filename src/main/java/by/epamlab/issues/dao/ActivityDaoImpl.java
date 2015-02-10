package by.epamlab.issues.dao;

import by.epamlab.issues.model.Activity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ActivityDaoImpl implements ActivityDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @SuppressWarnings("unchecked")
    public List<Activity> loadActivities() {
        List<Activity> activities = sessionFactory.getCurrentSession()
                .createQuery("from Activity ")
                .list();
        return activities;
    }

    @Override
    public void addActivity(Activity activity) {
        sessionFactory.getCurrentSession().save(activity);
    }
}
