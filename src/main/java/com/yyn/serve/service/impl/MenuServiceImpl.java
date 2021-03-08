package com.yyn.serve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyn.serve.bean.Menu;
import com.yyn.serve.mappers.MenuMapper;
import com.yyn.serve.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }


    @Override
    public List<Menu> getMenu(Menu menu) {
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>(menu);
        menuQueryWrapper.orderByAsc("pid","order_no");
        return this.menuMapper.selectList(menuQueryWrapper);
    }

    @Override
    public List<Menu> getUserMenus(Long uid) {
        return this.menuMapper.getUserMenus(uid);
    }
}
