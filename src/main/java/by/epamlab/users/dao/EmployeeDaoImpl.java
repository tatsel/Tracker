package by.epamlab.users.dao;

import by.epamlab.users.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public Employee findByLogin(String login) {
        List<Employee> employees = new ArrayList<Employee>();
        employees = sessionFactory.getCurrentSession()
                .createQuery("from Employee where login = :login")
                .setString("login", login)
                .list();

        if (employees.size() > 0) {
            return employees.get(0);
        } else {
            return null;
        }
    }
}
