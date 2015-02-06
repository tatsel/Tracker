package by.epamlab.users.service;

import by.epamlab.users.model.Employee;

import java.util.List;

public interface UserService {

    public List<Employee> loadUserList();
    public void addUser(Employee user);

    void deleteUser(Integer id);

    Employee getUserById(int employeeId);
}
