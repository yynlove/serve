package com.yyn.serve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yyn.serve.bean.Result;
import com.yyn.serve.bean.Users;

import java.util.List;

public interface UsersService {

    int insertOne(Users users);

    Users selectOne(Users users);

    Result<List<Users>> listUsers(IPage<Users> usersPage, Users users);

    Result updateUser(Users user);

    Integer checkAccount(String account);

    Integer deleteUserById(Integer id);

    Users selectById(Long uid);
}
