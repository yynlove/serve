package com.yyn.serve.bean;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Menu {



    private Long id;
    private String link;
    private String title;
    private Long pid;
    private Integer orderNo;
    private Date createTime;
    private Integer isValid;

    @TableField(exist = false)
    private List<Menu> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
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

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public static List<Menu> initChildren(List<Menu> menus){
        Map<Long, List<Menu>> collect = menus.stream().collect(Collectors.groupingBy(Menu::getPid));

        menus.forEach(menu2 -> {
            menu2.setChildren(collect.get(menu2.getId()));
        });
        return collect.get(0);
    }
}
