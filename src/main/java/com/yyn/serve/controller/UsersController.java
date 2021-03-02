package com.yyn.serve.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyn.serve.bean.LoginInfo;
import com.yyn.serve.jwtUtil.JWTUtil;
import com.yyn.serve.bean.Result;
import com.yyn.serve.bean.Users;
import com.yyn.serve.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {

    private  UsersService usersService;

    private  JWTUtil jwtUtil;

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
    public Result<List<Users>> listUsers(Integer pageIndex,Integer pageSize,String account,String userName,Integer age){
        final IPage<Users> usersPage = new Page<>(pageIndex, pageSize);
        Users users = new Users();
        users.setIsValid(1);
        if(!account.isEmpty()){
            users.setAccount(account);
        }
        if(!userName.isEmpty()){
            users.setUserName(userName);
        }
        if(age!=null){
            users.setAge(age);
        }
        return usersService.listUsers(usersPage,users);
    }

    @PostMapping("/login")
    public ResponseEntity<Result<LoginInfo>> login(@RequestBody Users user){
        user.setIsValid(1);
        Users users1 = usersService.selectOne(user);
        final String token = jwtUtil.getToken(users1);
        final LoginInfo loginInfo = new LoginInfo();
        loginInfo.setToken(token);
        loginInfo.setAccount(users1.getAccount());
        return ResponseEntity.ok().header("Authorization",token).body(new Result("登录成功",loginInfo));
    }

}
