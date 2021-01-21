package com.yyn.serve.service;

import com.yyn.serve.bean.Users;

import java.util.List;

public interface UsersService {

    int insertOne(Users users);

    Users selectOne(Users users);

    List<Users> listUsers();
}
