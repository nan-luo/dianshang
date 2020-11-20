package com.luo.dianshang.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 南磊
 * @date 2020/5/18 16:33
 * @Description
 */
@SpringBootTest
class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Test
    void test(){
        productCategoryMapper.selectList(null).forEach(System.out::println);
    }
}