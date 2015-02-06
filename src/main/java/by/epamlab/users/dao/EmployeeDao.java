package by.epamlab.users.dao;

import by.epamlab.users.model.Employee;

import java.util.List;


public interface EmployeeDao {

    Employee findByLogin(String login);

    List<Employee> findEmployees();

    void addUser(Employee user);

    void deleteUser(Integer id);

    Employee findById(int employeeId);
}
