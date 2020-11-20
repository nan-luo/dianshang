package com.luo.dianshang.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author 南磊
 * @date 2020/5/22 17:31
 * @Description
 */
@Getter
public enum GenderEnum {
    WOMAN(0,"女"),
    MAN(1,"男");

    @EnumValue
    private Integer code;
    private String value;

    GenderEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
