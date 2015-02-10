package by.epamlab.users.service;

import by.epamlab.projects.model.Project;
import by.epamlab.users.model.Employee;

import java.util.List;

public interface UserService {

    public List<Employee> loadUserList();
    public void addUser(Employee user);

    void deleteUser(Integer id);

    Employee getUserById(int employeeId);

    List<Employee> loadUsersNotMembers(Project projectById);

    Employee findUserByLogin(String name);
}
