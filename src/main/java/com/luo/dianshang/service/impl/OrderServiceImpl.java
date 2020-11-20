package com.luo.dianshang.service.impl;

import com.luo.dianshang.entity.Orders;
import com.luo.dianshang.entity.User;
import com.luo.dianshang.mapper.OrderMapper;
import com.luo.dianshang.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 花折
 * @since 2020-05-18
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {

    @Override
    public boolean save(Orders orders, User user) {
        orders.setUserId(user.getId());
        orders.setLoginName(user.getLoginName());

        String seriaNumber = null;
        try {
            StringBuffer result = new StringBuffer();
            for(int i=0;i<32;i++) {
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }
            seriaNumber =  result.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        orders.setSerialnumber(seriaNumber);
        return  save(orders);
    }
}
