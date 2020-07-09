package com.yh.serve.bean;

import com.yh.serve.service.Authable;

import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Table(name = "users")
public class Users implements Serializable, Authable {

    @Id
    private Long id;


    private String userName;

    private String passWord;

    private String md5;

    private Date createTime;

    private Integer isValid;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", md5='" + md5 + '\'' +
                ", createTime=" + createTime +
                ", isValid=" + isValid +
                '}';
    }

    @Override
    public String getIssuer() {
        return this.userName;
    }

    @Override
    public Map<String, Object> getClaims() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("refreshCount", 0);
        claims.put("userId", id);
        return claims;
    }

}
