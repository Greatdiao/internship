package com.odianyun.internship.model.DTO;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: EDZ
 * @time: 10:25
 * @date: 2021/7/16
 */
public class SoDTO implements Serializable {
    private static final long serialVersionUID = 78924230410087928L;
    private Long id;

    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 父订单号
     */
    private String parentOrderCode;
    /**
     * 商品编码
     */
    private String code;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 商家id
     */
    private Long merchantId;
    /**
     * 店铺id
     */
    private Long storeId;
    /**
     * idList
     */
    private List<Long> idList;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页数
     */
    private Integer pageSize;

    /**
     * 订单创建开始时间
     */
    private String startOrderCreateTime;
    /**
     * 订单创建结束时间
     */
    private String endOrderCreateTime;

    /**
     * 是否有用户备注
     */
    private Integer isOrderRemarkUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getParentOrderCode() {
        return parentOrderCode;
    }

    public void setParentOrderCode(String parentOrderCode) {
        this.parentOrderCode = parentOrderCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStartOrderCreateTime() {
        return startOrderCreateTime;
    }

    public void setStartOrderCreateTime(String startOrderCreateTime) {
        this.startOrderCreateTime = startOrderCreateTime;
    }

    public String getEndOrderCreateTime() {
        return endOrderCreateTime;
    }

    public void setEndOrderCreateTime(String endOrderCreateTime) {
        this.endOrderCreateTime = endOrderCreateTime;
    }

    public Integer getIsOrderRemarkUser() {
        return isOrderRemarkUser;
    }

    public void setIsOrderRemarkUser(Integer isOrderRemarkUser) {
        this.isOrderRemarkUser = isOrderRemarkUser;
    }
}
