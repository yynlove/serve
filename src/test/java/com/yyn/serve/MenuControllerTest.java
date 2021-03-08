package com.yyn.serve;


import com.yyn.serve.bean.Menu;
import com.yyn.serve.service.MenuService;
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
        @Test
        public void testMenu() throws Exception{
            Menu menu = new Menu();
            menu.setIsValid(1);
            List<Menu> menu1 = this.menuService.getMenu(menu);


            Map<Long, List<Menu>> collect = menu1.stream().collect(Collectors.groupingBy(Menu::getPid));

            menu1.forEach(menu2 -> {
                menu2.setChildren(collect.get(menu2.getId()));
            });
            //System.out.println(userMenu1.toString());
        }


}
