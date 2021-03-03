package com.yyn.serve.SecurityJwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

public class JwtUserService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    public JwtUserService() {
        //默认使用 bcrypt， strength=10
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //真实系统需要从数据库或缓存中获取，这里对密码做了加密
        return User.builder().username("admin").password(passwordEncoder.encode("123456")).roles("USER").build();
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
}
