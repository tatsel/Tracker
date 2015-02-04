package by.epamlab.users.dao;

import by.epamlab.users.model.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<UserRole> findUserRoles() {
        List<UserRole> userRoles = new ArrayList<UserRole>();
        userRoles = sessionFactory.getCurrentSession()
                .createQuery("from UserRole")
                .list();
        return userRoles;
    }

    @Override
    public UserRole getRole(String name) {
        UserRole role;
        role = (UserRole) sessionFactory.getCurrentSession()
                .createQuery("from UserRole where name = :name")
                .setString("name", name)
                .uniqueResult();
        return role;
    }
}
