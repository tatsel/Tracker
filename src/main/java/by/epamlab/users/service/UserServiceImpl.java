package by.epamlab.users.service;

import by.epamlab.users.dao.EmployeeDao;
import by.epamlab.users.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> loadUserList() {
        return employeeDao.findEmployees();
    }

    @Override
    public void addUser(Employee user) {
        employeeDao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        employeeDao.deleteUser(id);
    }
}
