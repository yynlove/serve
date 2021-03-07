package com.yyn.serve;


import com.alibaba.fastjson.JSON;
import com.yyn.serve.bean.Menu;
import com.yyn.serve.bean.UserMenu;
import com.yyn.serve.bean.Users;
import com.yyn.serve.service.MenuService;
import com.yyn.serve.service.UserMenuService;
import com.yyn.serve.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ServeApplication.class)
@WebAppConfiguration
public class MenuControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(MenuControllerTest.class);
    @Autowired
    private MenuService menuService;
    @Autowired
    private UserMenuService userMenuService;

        @Test
        public void testMenu() throws Exception{
            Menu menu = new Menu();
            menu.setIsValid(1);
            List<Menu> menu1 = this.menuService.getMenu(menu);


            Map<Long, List<Menu>> collect = menu1.stream().collect(Collectors.groupingBy(Menu::getPid));

            menu1.forEach(menu2 -> {
                menu2.setChildren(collect.get(menu2.getId()));
            });

            String s = JSON.toJSONString(collect.get(0L));
            UserMenu userMenu = new UserMenu();
            userMenu.setUserId(1L);
            userMenu.setUserMenus(s);
             userMenuService.insertOne(userMenu);
            //System.out.println(userMenu1.toString());
        }


}
