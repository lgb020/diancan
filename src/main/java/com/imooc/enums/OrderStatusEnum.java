package com.imooc.enums;

import lombok.Getter;

/**
 * Created by wwd
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单未支付"),
    NEW_PAYED(1, "新订单已支付"),
    CANCEL(2, "已取消"),
    FINISHED(3, "完结"),
    COMMENT(4, "已评价"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
