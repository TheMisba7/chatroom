package com.mansar.chatroom.security;

import com.mansar.chatroom.model.Role;
import com.mansar.chatroom.model.User;
import com.mansar.chatroom.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        for (Role role: user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.name()));
        }
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), roles);
    }
}
