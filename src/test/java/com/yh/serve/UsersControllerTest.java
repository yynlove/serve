package com.yh.serve;


import com.yh.serve.bean.Users;
import com.yh.serve.service.UsersService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ServeApplication.class)
@WebAppConfiguration
public class UsersControllerTest {



        @Autowired
        private UsersService usersService;

        @Test
        public void testUser() throws Exception{
            Users users = new Users();
            users.setUserName("admin");
            users.setPassWord("123456");
            users.setCreateTime(new Date());
            int i = usersService.insertOne(users);
            System.out.println(i);
        }



}
