package com.yyn.serve.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yyn.serve.bean.Menu;
import com.yyn.serve.bean.Users;
import com.yyn.serve.service.MenuService;
import com.yyn.serve.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("menu")
public class MenuController {

    private static  final Logger logger = LoggerFactory.getLogger(MenuController.class);

    private MenuService menuService;
    private UsersService usersService;
    @Autowired
    public MenuController(MenuService menuService, UsersService usersService) {
        this.menuService = menuService;
        this.usersService = usersService;
    }


    @GetMapping("getUserMenus")
    public Map<String, Object> getUserMenus(Long uid){
        final Users users = this.usersService.selectById(uid);
        List<Menu> menus = Menu.initChildren(this.menuService.getUserMenus(uid));
        final HashMap<String, Object> map = new HashMap<>(2);
        map.put("user",users);
        map.put("menus", JSONArray.parseArray(JSON.toJSONString(menus),Menu.class));
        return map;

    }


}
