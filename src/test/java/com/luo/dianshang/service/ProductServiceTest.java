package com.luo.dianshang.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luo.dianshang.entity.Product;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 南磊
 * @date 2020/5/20 16:19
 * @Description
 */
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void test(){
        Map<String,Object> map=new HashMap<>();
        map.put("categorylevelthree_id",655);
        productService.listByMap(map).forEach(System.out::println);
    }
}