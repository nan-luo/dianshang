package com.luo.dianshang.service.impl;

import com.luo.dianshang.service.ProductCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 南磊
 * @date 2020/5/18 16:09
 * @Description
 */
@SpringBootTest
class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryService service;

    @Test
    void getAllProductCategoryVO() {
        service.getAllProductCategoryVO();
    }
}