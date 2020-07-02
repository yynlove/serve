package com.yh.serve.service.impl;

import com.yh.serve.bean.Users;
import com.yh.serve.mappers.UsersMapper;
import com.yh.serve.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public int insertOne(Users users) {
        return usersMapper.insertSelective(users);
    }
}
