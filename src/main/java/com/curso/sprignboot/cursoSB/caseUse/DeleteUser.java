package com.curso.sprignboot.cursoSB.caseUse;

import com.curso.sprignboot.cursoSB.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService userservice;

    public DeleteUser(UserService userService) {
        this.userservice = userService;
    }

    public void remove(Long id) {
        userservice.delete(id);
    }
}
