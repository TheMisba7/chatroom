package com.mansar.chatroom.dto;

import com.mansar.chatroom.core.Validation;
import com.mansar.chatroom.model.Role;
import com.mansar.chatroom.model.Room;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class UserDTO {
    private int id;
    @NotBlank(message = "name is Mandatory")
    private String name;
    @NotBlank(message = "Email is Mandatory")
    private String email;
    @Pattern(regexp = Validation.PASSWORD, message = "password is Mandatory")
    private String password;
    private List<Role> roles;
    private Room room;
}
