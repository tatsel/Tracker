package by.epamlab.users.dao;

import by.epamlab.users.model.Employee;

/**
 * Created by Aliaksandr_Asiptsou on 1/20/2015.
 */
public interface EmployeeDao {

    Employee findByLogin(String login);

}
