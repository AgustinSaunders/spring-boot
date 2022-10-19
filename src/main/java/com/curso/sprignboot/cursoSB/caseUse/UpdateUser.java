package com.curso.sprignboot.cursoSB.caseUse;

import com.curso.sprignboot.cursoSB.entity.User;
import com.curso.sprignboot.cursoSB.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userservice;

    public UpdateUser(UserService userService) {
        this.userservice = userService;
    }

    public User update(User newUser, Long id) {
        return userservice.update(newUser, id);

    }
}
