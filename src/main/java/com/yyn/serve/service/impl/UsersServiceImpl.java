package com.yyn.serve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yyn.serve.bean.Result;
import com.yyn.serve.bean.Users;
import com.yyn.serve.mappers.UsersMapper;
import com.yyn.serve.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {

    private final UsersMapper usersMapper;

    @Autowired
    public UsersServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }


    @Override
    public int insertOne(Users users) {
        return usersMapper.insert(users);
    }

    @Override
    public Users selectOne(Users users) {
        return usersMapper.selectOne(new QueryWrapper<>(users));
    }

    @Override
    public Result<List<Users>> listUsers(IPage<Users> usersPage) {
        final IPage<Users> usersIPage = usersMapper.selectPage(usersPage, null);
        final Integer count = usersMapper.selectCount(null);
        final Result<List<Users>> listResult = new Result<>(HttpStatus.OK,null,count,usersIPage.getRecords());
        return listResult;
    }

    @Override
    public Result updateUser(Users user) {
        final int i = this.usersMapper.updateById(user);
        if(i>0){
            return new Result(HttpStatus.OK,"修改成功。");
        }
        return new Result(HttpStatus.NOT_FOUND,"修改失败。");
    }

    @Override
    public Integer checkAccount(String account) {
        Users users = new Users();
        users.setAccount(account);
        users.setIsValid(1);
        return this.usersMapper.selectCount(new QueryWrapper<>(users));
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return this.usersMapper.deleteById(id);
    }


}
