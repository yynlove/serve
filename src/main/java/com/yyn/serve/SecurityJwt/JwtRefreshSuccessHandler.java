package com.yyn.serve.SecurityJwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


/**
 * 如果token认证失败，并且不在permissive列表中话，就会调用FailHandler，这个Handler和登录行为一致，所以都使用HttpStatusLoginFailureHandler 返回401错误。
 * token认证成功，在继续FilterChain中的其它Filter之前，我们先检查一下token是否需要刷新，刷新成功后会将新token放入header中。
 * 所以，新增一个JwtRefreshSuccessHandler来处理token认证成功的情况。
 */
public class JwtRefreshSuccessHandler implements AuthenticationSuccessHandler {

    //刷新间隔5分钟
    private static final int tokenRefreshInterval = 300;

    private JwtUserService jwtUserService;

    public JwtRefreshSuccessHandler(JwtUserService jwtUserService) {
        this.jwtUserService = jwtUserService;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        DecodedJWT jwt = ((JwtAuthenticationToken)authentication).getToken();
        boolean shouldRefresh = shouldTokenRefresh(jwt.getIssuedAt());
        if(shouldRefresh) {
            String newToken = jwtUserService.saveUserLoginInfo((UserDetails)authentication.getPrincipal());
            response.setHeader("Authorization", newToken);
        }
    }

    private boolean shouldTokenRefresh(Date issuedAt) {
        LocalDateTime issueTime = LocalDateTime.ofInstant(issuedAt.toInstant(), ZoneId.systemDefault());
        return LocalDateTime.now().minusSeconds(tokenRefreshInterval).isAfter(issueTime);

    }


}
