package com.yyn.serve.service;


import com.yyn.serve.bean.UserMenu;

public interface UserMenuService {

    int insertOne(UserMenu userMenu);

    int updateById(UserMenu userMenu);

    UserMenu selectOne(UserMenu userMenu);
}
