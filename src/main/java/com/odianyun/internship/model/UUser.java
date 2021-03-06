package com.odianyun.internship.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: EDZ
 * @time: 14:27
 * @date: 2021/7/15
 */
public class UUser implements Serializable {
    private static final long serialVersionUID = 6071305180207124673L;

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

    private Long companyId;

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
