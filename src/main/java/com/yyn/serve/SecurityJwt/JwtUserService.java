package com.yyn.serve.SecurityJwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyn.serve.bean.Users;
import com.yyn.serve.mappers.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;


/**
 * 用户获取是调用了UserDetailsService来完成的。这个是一个只有一个方法的接口，所以我们自己要做的，
 * 就是将自己的UserDetailsService实现类配置成一个Bean。下面是实例代码，真正的实现需要从数据库或者缓存中获取。
 */
@Service
public class JwtUserService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersMapper usersMapper;

    public JwtUserService() {
        //默认使用 bcrypt， strength=10
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        //真实系统需要从数据库或缓存中获取，这里对密码做了加密
        final Users users = new Users();
        users.setAccount(account);
        users.setIsValid(1);
        final Users users1 = usersMapper.selectOne(new QueryWrapper<Users>(users));
        return User.builder().username(users1.getAccount()).password(passwordEncoder.encode(users1.getPassword())).roles("USER").build();
    }

    public String saveUserLoginInfo(UserDetails userDetails) {
        //BCrypt.gensalt();  正式开发时可以调用该方法实时生成加密的salt
        String salt = "123456ef";
        //将salt保存到数据库或者缓存中
        Algorithm algorithm = Algorithm.HMAC256(salt);
        //设置1小时后过期
        Date date = new Date(System.currentTimeMillis()+3600*1000);
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(date)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }


    public Users getUserId(UserDetails userDetails){

        Users users = new Users();
        users.setAccount(userDetails.getUsername());
        users.setIsValid(1);
        return this.usersMapper.selectOne(new QueryWrapper<>(users));
    }

    public UserDetails getUserLoginInfo(String username) {
        String salt = "123456ef";
         //从数据库或者缓存中取出jwt token生成时用的salt

        UserDetails user = loadUserByUsername(username);
        //将salt放到password字段返回
        return User.builder().username(user.getUsername()).password(salt).authorities(user.getAuthorities()).build();
    }

    public void deleteUserLoginInfo(String username) {
    }
}
