package com.yh.serve.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "jjwt")
@Component
public class AuthProperties {

    private String secret;

    private long expirationTime;

    private long refreshInterval;


    public AuthProperties() {
    }

    public AuthProperties(String secret, long expirationTime, long refreshInterval) {
        this.secret = secret;
        this.expirationTime = expirationTime;
        this.refreshInterval = refreshInterval;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public long getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(long refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    @Override
    public String toString() {
        return "AuthProperties{" +
                "secret='" + secret + '\'' +
                ", expirationTime='" + expirationTime + '\'' +
                ", refreshInterval=" + refreshInterval +
                '}';
    }
}
