package com.yyn.serve.controller;

import com.yyn.serve.jwtUtil.JWTUtil;
import com.yyn.serve.bean.Result;
import com.yyn.serve.bean.Users;
import com.yyn.serve.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/insertOne")
    public void insertOne(){
        Users users = new Users();
        users.setUserName("admin");
        users.setPassword("123456");
        users.setCreateTime(new Date());
        int i = usersService.insertOne(users);
        System.out.println(i);

    }


    @GetMapping("/listUsers")
    public List<Users> listUsers(){
        List<Users> users = usersService.listUsers();
        return users;
    }

    @GetMapping("/login")
    public ResponseEntity<Result<Users>> login(){
        Users users2 = new Users();
        Users users1 = usersService.selectOne(users2);
        return ResponseEntity.ok().header("Authorization",jwtUtil.getToken(users1)).body(new Result("登录成功",users1));
    }

}
