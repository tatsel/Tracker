package by.epamlab.users.dao;

import by.epamlab.users.model.UserRole;

import java.util.List;

public interface UserRoleDao {
    List<UserRole> findUserRoles();
    UserRole getRole(String name);

}
