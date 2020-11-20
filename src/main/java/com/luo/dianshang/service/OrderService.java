package com.luo.dianshang.service;

import com.luo.dianshang.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luo.dianshang.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 花折
 * @since 2020-05-18
 */
public interface OrderService extends IService<Orders> {
    public boolean save(Orders orders, User user);
}
