package com.yyn.serve.bean;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class UserMenu {

    @TableField
    private Long id;
    private Long userId;
    private String userMenus;
    private Date lastTime;
    private Integer isValid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserMenus() {
        return userMenus;
    }

    public void setUserMenus(String userMenus) {
        this.userMenus = userMenus;
    }



    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public String toString() {
        return "UserMenu{" +
                "id=" + id +
                ", userId=" + userId +
                ", userMenus='" + userMenus + '\'' +
                ", lastTime=" + lastTime +
                ", isValid=" + isValid +
                '}';
    }
}
