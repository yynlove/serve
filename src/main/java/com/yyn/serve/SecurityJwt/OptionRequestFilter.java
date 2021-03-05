package com.yyn.serve.SecurityJwt;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OptionRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(httpServletRequest.getMethod().equals("OPTIONS")) {
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,HEAD");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletResponse.getHeader("Access-Control-Request-Headers"));
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
