package by.epamlab.projects.dao;

import by.epamlab.projects.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Role> getRoles() {
        List<Role> roles;
        roles = sessionFactory.getCurrentSession()
                .createQuery("from Role")
                .list();
        return roles;
    }

    @Override
    public Role getRole(String rolename) {
        Role role = (Role)sessionFactory.getCurrentSession()
                .createQuery("from Role where name =:name")
                .setString("name", rolename)
                .uniqueResult();
        return role;
    }
}
