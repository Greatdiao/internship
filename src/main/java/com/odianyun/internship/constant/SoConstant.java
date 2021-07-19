package com.odianyun.internship.constant;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @description:
 * @author: EDZ
 * @time: 9:49
 * @date: 2021/7/19
 */
public class SoConstant {
    /**
     * 订单状态：待发货
     */
    public static final Integer ORDER_STATUS_UN_DELIVERY = 1050;

    public static final Integer ORDER_STATUS_DELIVERYED = 1060;

    public static final Integer ORDER_STATUS_CLOSED = 9000;

    public static final Integer FRONT_ORDER_STATUS_CLOSED = 1;

    public static final List<Integer> ORDER_STATUS_DELIVERY_List = Lists.newArrayList(ORDER_STATUS_UN_DELIVERY, ORDER_STATUS_DELIVERYED, 1070);

    public static Boolean checkStatus(Integer source, Integer target) {
        if (null == source || null == target) {
            return false;
        }
        return source.equals(target);
    }
}
