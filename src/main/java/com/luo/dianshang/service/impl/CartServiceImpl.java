package com.luo.dianshang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luo.dianshang.entity.Cart;
import com.luo.dianshang.entity.Product;
import com.luo.dianshang.enums.ResultEnum;
import com.luo.dianshang.exception.MallException;
import com.luo.dianshang.mapper.CartMapper;
import com.luo.dianshang.mapper.ProductMapper;
import com.luo.dianshang.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luo.dianshang.vo.CartVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 花折
 * @since 2020-05-18
 */
@Service
@Slf4j
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
   @Autowired
    private CartMapper cartMapper;
   @Autowired
   private ProductMapper productMapper;

    @Override
    public boolean save(Cart entity) {
        cartMapper.insert(entity);
        //扣库存
        Product product=productMapper.selectById(entity.getProductId());
        //算出剩下的库存
        Integer stock=product.getStock()-entity.getQuantity();

        if (stock < 0){
            log.error("【添加购物车，库存不足！】 stock={}",stock);
            throw new MallException(ResultEnum.STOCK_ERROR);
        }

        //判断库存是否为0
        product.setStock(stock);
        productMapper.updateById(product);
        if (cartMapper.insert(entity) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<CartVO> findAllCartVOByUserId(Integer id) {
        List<CartVO> cartVOList = new ArrayList<>();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",id);
        List<Cart> cartList = cartMapper.selectList(wrapper);
        for (Cart cart : cartList) {
            CartVO cartVO = new CartVO();
            Product product = productMapper.selectById(cart.getProductId());
            BeanUtils.copyProperties(product,cartVO);
            BeanUtils.copyProperties(cart,cartVO);
            cartVOList.add(cartVO);
        }
        return cartVOList;
    }

}
