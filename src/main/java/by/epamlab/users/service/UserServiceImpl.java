package by.epamlab.users.service;

import by.epamlab.projects.model.Member;
import by.epamlab.projects.model.Project;
import by.epamlab.users.dao.EmployeeDao;
import by.epamlab.users.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    @Override
    public Employee getUserById(int employeeId) {
        return employeeDao.findById(employeeId);
    }

    @Override
    public List<Employee> loadUsersNotMembers(Project project) {
        List<Employee> employees = employeeDao.findEmployees();
        Set<Member> members = project.getMembers();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            for (Member member: members) {
                if (member.getEmployee().getId() == employee.getId()) {
                    iterator.remove();
                }
            }
        }
        return employees;
    }
}
