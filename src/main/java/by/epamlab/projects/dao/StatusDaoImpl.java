package by.epamlab.projects.dao;

import by.epamlab.projects.model.Status;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatusDaoImpl implements StatusDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Status> getStatuses() {
        List<Status> statuses;
        statuses = sessionFactory.getCurrentSession()
                .createQuery("from Status")
                .list();
        return statuses;
    }

    @Override
    public Status getStatus(String statusName) {
        Status status = (Status)sessionFactory.getCurrentSession()
                .createQuery("from Status where name =:name")
                .setString("name", statusName)
                .uniqueResult();
        return status;
    }
}
