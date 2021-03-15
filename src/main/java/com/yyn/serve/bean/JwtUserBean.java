package com.yyn.serve.bean;

import java.util.concurrent.TimeUnit;

public class JwtUserBean {


    private String key;
    private String salt;

    private Long timeout;

    private TimeUnit seconds;


    public JwtUserBean(String key, String salt, Long timeout, TimeUnit seconds) {
        this.key = key;
        this.salt = salt;
        this.timeout = timeout;
        this.seconds = seconds;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public TimeUnit getSeconds() {
        return seconds;
    }

    public void setSeconds(TimeUnit seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "JwtUserBean{" +
                "key='" + key + '\'' +
                ", salt='" + salt + '\'' +
                ", timeout=" + timeout +
                ", seconds=" + seconds +
                '}';
    }
}
