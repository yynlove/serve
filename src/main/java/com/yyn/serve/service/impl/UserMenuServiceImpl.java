package com.yyn.serve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyn.serve.bean.Menu;
import com.yyn.serve.bean.UserMenu;
import com.yyn.serve.mappers.MenuMapper;
import com.yyn.serve.mappers.UserMenuMapper;
import com.yyn.serve.service.MenuService;
import com.yyn.serve.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMenuServiceImpl implements UserMenuService {


    private UserMenuMapper userMenuMapper;

    @Autowired
    public UserMenuServiceImpl(UserMenuMapper userMenuMapper) {
        this.userMenuMapper = userMenuMapper;
    }

    @Override
    public int insertOne(UserMenu userMenu) {
        return userMenuMapper.insert(userMenu);
    }

    @Override
    public int updateById(UserMenu userMenu) {
        return userMenuMapper.updateById(userMenu);
    }

    @Override
    public UserMenu selectOne(UserMenu userMenu) {
        return userMenuMapper.selectOne(new QueryWrapper<>(userMenu));
    }
}
