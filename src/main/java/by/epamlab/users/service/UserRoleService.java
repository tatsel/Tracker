package by.epamlab.users.service;

import by.epamlab.users.model.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> loadUserRoles();

    UserRole getRoleByName(String name);
}
