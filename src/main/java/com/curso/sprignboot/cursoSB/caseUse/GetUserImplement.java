package com.curso.sprignboot.cursoSB.caseUse;

import com.curso.sprignboot.cursoSB.entity.User;
import com.curso.sprignboot.cursoSB.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
