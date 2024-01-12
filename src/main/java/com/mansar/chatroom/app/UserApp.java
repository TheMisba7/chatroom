package com.mansar.chatroom.app;

import com.mansar.chatroom.dto.UserDTO;
import com.mansar.chatroom.mapper.UserMapper;
import com.mansar.chatroom.model.User;
import com.mansar.chatroom.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserApp {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserApp(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void create(UserDTO userDTO) {

        //Todo: make sure email doesn't exist
        userRepository.save(userMapper.fromDTO(userDTO));
    }

    public UserDTO getCurrentUser() {
        String email = String.valueOf(SecurityContextHolder
                .getContext().getAuthentication().getPrincipal());
        User user = userRepository.findByEmail(email);
        return userMapper.toDTO(user);
    }
}
