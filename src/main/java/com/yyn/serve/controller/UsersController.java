package com.yyn.serve.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyn.serve.jwtUtil.JWTUtil;
import com.yyn.serve.bean.Result;
import com.yyn.serve.bean.Users;
import com.yyn.serve.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
    private final JWTUtil jwtUtil;

    @Autowired
    public UsersController(UsersService usersService,JWTUtil jwtUtil){
        this.usersService = usersService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/insertOne")
    public Integer insertOne(@RequestBody Users user){
        int i = usersService.insertOne(user);
        return i;
    }


    @GetMapping("checkAccount")
    public Integer checkAccount(String account){
       return this.usersService.checkAccount(account);
    }


    @PutMapping("updateUser")
    public Result updateUser(@RequestBody Users user){
       Result result =  this.usersService.updateUser(user);
       return result;
    }


    @DeleteMapping("deleteUserById")
    public Integer deleteUserById(Integer id){
       return this.usersService.deleteUserById(id);
    }

    @GetMapping("/listUsers")
    public Result<List<Users>> listUsers(Integer pageIndex,Integer pageSize){
        final IPage<Users> usersPage = new Page<>(pageIndex, pageSize);
        final Result<List<Users>> listResult = usersService.listUsers(usersPage);
        return listResult;
    }

    @GetMapping("/login")
    public ResponseEntity<Result<Users>> login(){
        Users users2 = new Users();
        Users users1 = usersService.selectOne(users2);
        return ResponseEntity.ok().header("Authorization",jwtUtil.getToken(users1)).body(new Result("登录成功",users1));
    }

}
