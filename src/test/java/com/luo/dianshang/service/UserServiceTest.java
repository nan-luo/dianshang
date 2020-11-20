package com.luo.dianshang.service;

import com.luo.dianshang.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 南磊
 * @date 2020/5/20 15:37
 * @Description
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void test(){
        User user=new User();
        user.setUserName("q");
        user.setLoginName("qwe");
        user.setPassword("123");
        user.setGender(1);
        System.out.println(userService.save(user));
    }
}