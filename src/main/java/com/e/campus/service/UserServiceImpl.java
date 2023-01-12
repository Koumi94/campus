package com.e.campus.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.e.campus.model.User;
import com.e.campus.model.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.e.campus.repository.UserRepository;
import com.e.campus.repository.UserRoleRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j //to login things out
public class UserServiceImpl implements  UserService , UserDetailsService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user==null){
            log.error("No User has been found in the database");
            throw new UsernameNotFoundException("No User has been find in the database");
        }else {
            log.info("User found in the database: {} ", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);

    }


    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    @Override
    public UserRole saveUserRole(UserRole role) {
        log.info("Saving new role {} to the database", role.getName());
        return userRoleRepository.save(role);

    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role  {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username);
        UserRole role = userRoleRepository.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {
        log.info("fetching role  {} ", username);
        return userRepository.findByUsername(username);

    }

    @Override
    public List<User> getUsers() {
        log.info("fetching all the Users  {} ");
        return userRepository.findAll();
    }


}