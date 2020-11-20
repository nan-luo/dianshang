package com.luo.dianshang.controller;


import com.luo.dianshang.entity.Orders;
import com.luo.dianshang.entity.User;
import com.luo.dianshang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 花折
 * @since 2020-05-18
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/settlement3")
    public ModelAndView settlement3(Orders orders, HttpSession session){
        User user= (User) session.getAttribute("user");
        orderService.save(orders,user);
        return null;
    }

}

