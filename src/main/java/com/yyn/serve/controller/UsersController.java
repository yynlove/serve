package com.yyn.serve.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyn.serve.bean.Result;
import com.yyn.serve.bean.Users;
import com.yyn.serve.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.PriorityQueue;


@RestController
@RequestMapping("/users")
public class UsersController {

    private  UsersService usersService;



    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
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

        //获取用户名
        final Object credentials = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        System.out.println(credentials);
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

}
