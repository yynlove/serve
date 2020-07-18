package com.yh.serve.controller;

import com.yh.serve.JWTUtil;
import com.yh.serve.bean.Result;
import com.yh.serve.bean.Users;
import com.yh.serve.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

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
        users.setPassWord("123456");
        users.setCreateTime(new Date());
        int i = usersService.insertOne(users);
        System.out.println(i);

    }


    @PostMapping("/login")
    public ResponseEntity<Result<Users>> login( Map<String,Object> users){
        System.out.println(users);
        Users users2 = new Users();
        Users users1 = usersService.selectOne(users2);
        return ResponseEntity.ok().header("Authorization",jwtUtil.getToken(users1)).body(new Result("登录成功",users1));
    }

}
