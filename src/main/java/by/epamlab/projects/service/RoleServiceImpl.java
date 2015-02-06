package by.epamlab.projects.service;

import by.epamlab.projects.dao.RoleDao;
import by.epamlab.projects.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> loadRoleList() {
        return roleDao.getRoles();
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRole(roleName);
    }
}
