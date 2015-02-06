package by.epamlab.projects.service;

import by.epamlab.projects.model.Role;

import java.util.List;

public interface RoleService {
    public List<Role> loadRoleList();

    Role getRoleByName(String roleName);
}
