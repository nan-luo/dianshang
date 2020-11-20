package com.luo.dianshang.service;

import com.luo.dianshang.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luo.dianshang.vo.ProductCategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 花折
 * @since 2020-05-18
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    public List<ProductCategoryVO> getAllProductCategoryVO();

}
