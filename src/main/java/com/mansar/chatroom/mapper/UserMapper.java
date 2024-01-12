package com.mansar.chatroom.mapper;

import com.mansar.chatroom.dto.UserDTO;
import com.mansar.chatroom.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User fromDTO(UserDTO userDTO);

    UserDTO toDTO(User user);
}
