package com.yyn.serve.service.impl;

import com.yyn.serve.bean.Users;
import com.yyn.serve.mappers.UsersMapper;
import com.yyn.serve.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public int insertOne(Users users) {
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users selectOne(Users users) {
        return usersMapper.selectOne(users);
    }

    @Override
    public List<Users> listUsers() {
        return usersMapper.selectAll();
    }


}
