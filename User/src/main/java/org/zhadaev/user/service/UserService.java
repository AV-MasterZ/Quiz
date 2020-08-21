package org.zhadaev.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.zhadaev.user.model.Role;
import org.zhadaev.user.model.User;
import org.zhadaev.user.repository.IRoleRepository;
import org.zhadaev.user.repository.IUserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findById(final Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public boolean saveUser(final User user) {

        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singleton(role));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;

    }

}
