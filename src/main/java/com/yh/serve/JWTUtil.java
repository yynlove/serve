package com.yh.serve;



import com.yh.serve.bean.AuthConstant;
import com.yh.serve.bean.AuthProperties;
import com.yh.serve.exception.AuthExpirationException;
import com.yh.serve.service.Authable;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


@Component
public class JWTUtil implements Serializable {

    @Autowired
    private  AuthProperties authProperties;


    public Claims getAllClaimsFromToken(String token) {
        JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(authProperties.getSecret().getBytes())).build();

        return jwtParser.parseClaimsJws(token).getBody();
    }

    public String getToken(Authable authable) {
        return generateToken(authable.getIssuer(), authable.getClaims());
    }

    private String refreshToken(Claims claims) {
        return generateToken(claims.getIssuer(), claims);
    }

    private String generateToken(String issuer, Map<String, Object> claims) {
        claims.merge(AuthConstant.REFRESH_COUNT, 0, (value, newValue) -> (Integer) value < 3 ? (Integer) value + 1 : value);
        Integer refreshCount = (Integer) claims.get(AuthConstant.REFRESH_COUNT);
        //long expirationTimeLong = Long.parseLong(authProperties.getExpirationTime());
        long expirationTimeLong = authProperties.getExpirationTime();
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + (refreshCount + 1) * expirationTimeLong * 1);
        return Jwts.builder()
                .setIssuer(issuer)//发行
                .setClaims(claims) //正文
                .setIssuedAt(createdDate) //开始时间
                .setExpiration(expirationDate) //过期时间
                .signWith(Keys.hmacShaKeyFor(authProperties.getSecret().getBytes())) //签名
                .compact();
    }

    public Map<String, Object> validateToken(String token) {
       /* 成功则返回user 失败抛出未授权异常，但是如果要刷新token，我想也在这里完成，因为如果后面判断token是否过期
        就还需要再解析一次token，解token是比较消耗性能的，因此这里需要一个东西存token
        超时时间可以随着刷新自增长 最大为7天*/
        Claims claims = getAllClaimsFromToken(token);
        long difference = claims.getExpiration().getTime() - System.currentTimeMillis();
        if (difference < 0) {
            //无效 抛token过期异常
            throw new AuthExpirationException(HttpStatus.UNAUTHORIZED, "登录身份信息过期");
        }
        if (difference < authProperties.getRefreshInterval()) {
            //小于一定区间，刷新
            token = refreshToken(claims);
            claims.put("newToken", token);
        }
        return claims;
    }

}
