package com.luo.dianshang.service;

import com.luo.dianshang.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 花折
 * @since 2020-05-18
 */
public interface ProductService extends IService<Product> {
    public List<Product>findByCategoryId(String type,Integer categoryId);
}
