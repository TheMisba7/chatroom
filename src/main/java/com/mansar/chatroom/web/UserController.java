package com.mansar.chatroom.web;

import com.mansar.chatroom.app.UserApp;
import com.mansar.chatroom.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserApp userApp;

    public UserController(UserApp userApp) {
        this.userApp = userApp;
    }

    @GetMapping(path = "/create", produces = MediaType.TEXT_HTML_VALUE)
    public String create() {
        return "users/create";
    }

    @PostMapping(path = "/create")
    public String create(final UserDTO userDTO) {
        userApp.create(userDTO);
        return "redirect:/login";
    }
}
