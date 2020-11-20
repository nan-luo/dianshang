package com.luo.dianshang.enums;

import lombok.Getter;

/**
 * @author 南磊
 * @date 2020/5/21 18:00
 * @Description
 */
@Getter
public enum  ResultEnum {

    STOCK_ERROR(1,"库存不足");

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;
}
