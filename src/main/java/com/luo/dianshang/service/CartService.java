package com.luo.dianshang.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.luo.dianshang.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luo.dianshang.vo.CartVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 花折
 * @since 2020-05-18
 */
public interface CartService extends IService<Cart> {
    public List<CartVO> findAllCartVOByUserId(Integer id);
}
