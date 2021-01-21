package com.yyn.serve;


import com.yyn.serve.jwtUtil.JWTUtil;
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
    @Autowired
    private JWTUtil jwtUtil;




        @Test
        public void testUser() throws Exception{
         /*   Users users = new Users();
            users.setUserName("admin");
            users.setPassWord("123456");
            Users users1= usersService.selectOne(users);
            System.out.println(users1.toString());*/
        }

        @Test
        public void getTokenTest(){

           /* Users users = new Users();
            users.setUserName("admin");
            users.setPassWord("123456");
            Users users1= usersService.selectOne(users);
            String token = jwtUtil.getToken(users1);
            logger.info("token-->"+token);
            Map<String, Object> stringObjectMap = jwtUtil.validateToken(token);
            logger.info("tokeninfo-->"+stringObjectMap.toString());
*/
        }


}
