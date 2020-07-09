package com.yh.serve.controller;

import com.yh.serve.bean.Users;
import com.yh.serve.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

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


    @PostMapping("/login")
    public String login(@RequestParam Map<String,Object> map){
        System.out.println(map.toString());
        return "200";
    }

}
