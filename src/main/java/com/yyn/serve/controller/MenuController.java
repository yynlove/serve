package com.yyn.serve.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yyn.serve.bean.Menu;
import com.yyn.serve.bean.Result;
import com.yyn.serve.bean.UserMenu;
import com.yyn.serve.bean.Users;
import com.yyn.serve.service.MenuService;
import com.yyn.serve.service.UserMenuService;
import com.yyn.serve.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("menu")
public class MenuController {

    private static  final Logger logger = LoggerFactory.getLogger(MenuController.class);

    private MenuService menuService;
    private UsersService usersService;
    private UserMenuService userMenuService;
    @Autowired
    public MenuController(MenuService menuService, UsersService usersService, UserMenuService userMenuService) {
        this.menuService = menuService;
        this.usersService = usersService;
        this.userMenuService = userMenuService;
    }




    @GetMapping("getUserMenus")
    public Map<String, Object> getUserMenus(Long uid){

        Users users1 = this.usersService.selectById(uid);
        UserMenu userMenu = new UserMenu();
        userMenu.setUserId(users1.getId());
        userMenu.setIsValid(1);
        UserMenu userMenu1 = this.userMenuService.selectOne(userMenu);
        Map<String, Object> stringObjectHashMap = new HashMap<>(2);
        stringObjectHashMap.put("user",users1);
        stringObjectHashMap.put("menus", JSONObject.parseArray(userMenu1.getUserMenus(),Menu.class));
        return stringObjectHashMap;
    }


}
