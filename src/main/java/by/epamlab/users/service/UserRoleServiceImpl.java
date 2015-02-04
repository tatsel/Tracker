package by.epamlab.users.service;

import by.epamlab.users.dao.UserRoleDao;
import by.epamlab.users.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;

    @Transactional
    @Override
    public List<UserRole> loadUserRoles() {
        return userRoleDao.findUserRoles();
    }

    @Transactional
    @Override
    public UserRole getRoleByName(String name) {
        return userRoleDao.getRole(name);
    }
}
