package com.e.campus.service;

import com.e.campus.model.User;
import com.e.campus.model.UserRole;

import java.util.List;

public interface UserService {
    User saveUser (User user);
    UserRole saveUserRole(UserRole role);

    void addRoleToUser(String username, String roleName);
    User getUser( String username);
    List<User> getUsers();
}