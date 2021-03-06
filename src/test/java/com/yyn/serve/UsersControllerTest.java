package com.yyn.serve;


import com.yyn.serve.bean.Users;
import com.yyn.serve.service.UsersService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ServeApplication.class)
@WebAppConfiguration
public class UsersControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(UsersControllerTest.class);
    @Autowired
    private UsersService usersService;


        @Test
        public void testUser() throws Exception{
            Users users = new Users();
            users.setUserName("admin");
            users.setPassword("123456");
            Users users1= usersService.selectOne(users);
            System.out.println(users1.toString());
        }


}
