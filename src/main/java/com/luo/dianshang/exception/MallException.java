package com.luo.dianshang.exception;

import com.luo.dianshang.enums.ResultEnum;

/**
 * @author 南磊
 * @date 2020/5/21 17:27
 * @Description
 */
/**
 * unchecked 不用去处理，交给JVM去处理 继承RuntimeException
 * checked 需要自己处理 继承Exception
 * */
public class MallException extends RuntimeException {
    public MallException(String error) {
    super(error);
    }
    public MallException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
    }
}
