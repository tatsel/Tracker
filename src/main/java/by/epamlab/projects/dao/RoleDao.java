package by.epamlab.projects.dao;

import by.epamlab.projects.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getRoles();

    Role getRole(String role);
}
