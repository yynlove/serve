package com.yyn.serve.bean;

import com.yyn.serve.service.Authable;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Users implements Serializable, Authable {

    private Long id;

    private String userName;

    private String password;

    private String md5;

    private String address;

    private Integer age;

    private Date createTime;

    private Integer isValid;

    private String account;

    private Integer gender;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", md5='" + md5 + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                ", isValid=" + isValid +
                ", account='" + account + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public String getIssuer() {
        return this.account;
    }

    @Override
    public Map<String, Object> getClaims() {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("refreshCount", 0);
        claims.put("userId", id);
        return claims;
    }

}
