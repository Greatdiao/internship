package com.odianyun.internship.model.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: EDZ
 * @time: 14:56
 * @date: 2021/7/15
 */
public class UUserDTO implements Serializable {
    private static final long serialVersionUID = 7994302290862596981L;
    /**
     * id
     */
    private Long id;

    /**
     * 手机号
     */
    private String mobile;

    private String password;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
