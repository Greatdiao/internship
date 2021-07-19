package com.odianyun.internship.constant;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: EDZ
 * @time: 9:49
 * @date: 2021/7/19
 */
public class SoConstant {

    /**
     * 待支付
     */
    public static final Integer ORDER_STATUS_UN_PAY = 1010;
    /**
     * 待确认
     */
    public static final Integer ORDER_STATUS_UN_CONFIRM = 1030;
    /**
     * 已确认
     */
    public static final Integer ORDER_STATUS_UN_CONFIRMED = 1030;
    /**
     * 已审核
     */
    public static final Integer ORDER_STATUS_UN_AUDITED = 1040;
    /**
     * 订单状态：待发货
     */
    public static final Integer ORDER_STATUS_UN_DELIVERY = 1050;
    /**
     * 订单状态：已发货
     */
    public static final Integer ORDER_STATUS_DELIVERED = 1060;
    /**
     * 订单状态：已签收
     */
    public static final Integer ORDER_STATUS_SIGNED = 1070;
    /**
     * 订单状态：已完成
     */
    public static final Integer ORDER_STATUS_COMPLETED = 1090;
    /**
     * 订单状态: 已关闭
     */
    public static final Integer ORDER_STATUS_CLOSED = 9000;


    /**
     * 前台状态
     */
    public static final Integer FRONT_ORDER_STATUS_CLOSED = 1;

    public static final List<Integer> ORDER_STATUS_DELIVERY_List = Lists.newArrayList(ORDER_STATUS_UN_DELIVERY, ORDER_STATUS_DELIVERED, 1070);

    public static Boolean checkStatus(Integer source, Integer target) {
        if (null == source || null == target) {
            return false;
        }
        return source.equals(target);
    }

    public static Map<Integer, String> STATUS_MAP = new HashMap<Integer, String>(){
        {
            put(ORDER_STATUS_UN_PAY, "待支付");
            put(ORDER_STATUS_UN_CONFIRM, "待确认");
            put(ORDER_STATUS_UN_CONFIRMED, "已确认");
            put(ORDER_STATUS_UN_AUDITED, "已审核");
            put(ORDER_STATUS_UN_DELIVERY, "待发货");
            put(ORDER_STATUS_DELIVERED, "已发货");
            put(ORDER_STATUS_SIGNED, "已签收");
            put(ORDER_STATUS_COMPLETED, "已完成");
            put(ORDER_STATUS_CLOSED, "已关闭");
        }
    };

}
