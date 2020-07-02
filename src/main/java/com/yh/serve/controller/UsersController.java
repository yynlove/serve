package com.yh.serve.controller;

import com.yh.serve.bean.Users;
import com.yh.serve.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @GetMapping("/insertOne")
    public void insertOne(){
        Users users = new Users();
        users.setUserName("admin");
        users.setPassWord("123456");
        users.setCreateTime(new Date());
        int i = usersService.insertOne(users);
        System.out.println(i);

    }


}
