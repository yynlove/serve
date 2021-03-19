package com.yyn.serve.SecurityJwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyn.serve.bean.JwtUserBean;
import com.yyn.serve.bean.Users;
import com.yyn.serve.mappers.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 用户获取是调用了UserDetailsService来完成的。这个是一个只有一个方法的接口，所以我们自己要做的，
 * 就是将自己的UserDetailsService实现类配置成一个Bean。下面是实例代码，真正的实现需要从数据库或者缓存中获取。
 */
@Service
public class JwtUserService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;
    //用来存储用户数据
    private static final ConcurrentHashMap<String,JwtUserBean> concurrentHashMap = new ConcurrentHashMap();


    @Autowired
    private UsersMapper usersMapper;

    public JwtUserService() {
        //默认使用 bcrypt， strength=10
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        //真实系统需要从数据库或缓存中获取，这里对密码做了加密
        //String salt = "123456ef";
        //final String salt = map.get("token:" + account).getSalt();
        final Users users = new Users();
        users.setAccount(account);
        users.setIsValid(1);
        final Users users1 = usersMapper.selectOne(new QueryWrapper<Users>(users));
        final String encode = passwordEncoder.encode(users1.getPassword());
        return User.builder().username(users1.getAccount()).password(passwordEncoder.encode(users1.getPassword())).roles("USER").build();
    }


    public String saveUserLoginInfo(UserDetails userDetails) {
        //BCrypt.gensalt();
        //正式开发时可以调用该方法实时生成加密的salt
        final String gensalt = BCrypt.gensalt();
        Date date = new Date( System.currentTimeMillis() + 1*60*1000 );
        final JwtUserBean jwtUserBean = new JwtUserBean("token:" + userDetails.getUsername(), gensalt, date.getTime(), TimeUnit.SECONDS);
        concurrentHashMap.put(jwtUserBean.getKey(),jwtUserBean);
        //将salt保存到数据库或者缓存中
        Algorithm algorithm = Algorithm.HMAC256(gensalt);
        //设置1小时后过期
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(date)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }


    public Users getUser(UserDetails userDetails){
        Users users = new Users();
        users.setAccount(userDetails.getUsername());
        users.setIsValid(1);
        final JwtUserBean jwtUserBean = concurrentHashMap.get("token:" + userDetails.getUsername());
        final Users users1 = this.usersMapper.selectOne(new QueryWrapper<>(users));
        users1.setTimeout(TimeUnit.NANOSECONDS.toSeconds(jwtUserBean.getTimeout()));
        return users1;
    }

    public UserDetails getUserLoginInfo(String username) {
        //String salt = "123456ef";
        //从数据库或者缓存中取出jwt token生成时用的salt
        final String salt = concurrentHashMap.get("token:" + username).getSalt();
        UserDetails user = loadUserByUsername(username);
        //将salt放到password字段返回
        return User.builder().username(user.getUsername()).password(salt).authorities(user.getAuthorities()).build();
    }

    public void deleteUserLoginInfo(String username) {
        concurrentHashMap.remove("token:"+username);
        System.out.println(concurrentHashMap.size());
    }
}
