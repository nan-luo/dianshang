package com.luo.dianshang.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 南磊
 * @date 2020/5/22 11:30
 * @Description
 */
@SpringBootTest
class CartServiceTest {

    @Autowired
    private CartService cartService;
    @Test
    void findAllCarVOByUserId() {
        cartService.findAllCartVOByUserId(10).forEach(System.out::println);
    }
}