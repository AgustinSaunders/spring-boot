package com.curso.sprignboot.cursoSB.caseUse;

import com.curso.sprignboot.cursoSB.entity.User;
import com.curso.sprignboot.cursoSB.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userservice;

    public CreateUser(UserService userService) {
        this.userservice = userService;
    }

    public User save(User newUser) {
        return userservice.save(newUser);
    }
}
