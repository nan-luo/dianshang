package com.luo.dianshang.controller;


import com.luo.dianshang.entity.Product;
import com.luo.dianshang.entity.User;
import com.luo.dianshang.service.CartService;
import com.luo.dianshang.service.ProductCategoryService;
import com.luo.dianshang.service.ProductService;
import com.luo.dianshang.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 花折
 * @since 2020-05-18
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private CartService cartService;

    @GetMapping("/list/{type}/{id}")
    public ModelAndView list(
            @PathVariable("type") String type,
            @PathVariable("id") Integer id,
            HttpSession session
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productList");
        modelAndView.addObject("productList",productService.findByCategoryId(type,id));
        modelAndView.addObject("list",productCategoryService.getAllProductCategoryVO());
        User user = (User)session.getAttribute("user");
        if(user == null){
            modelAndView.addObject("cartList",new ArrayList<>());
        }else{
            modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        }
        return modelAndView;
    }

//    @PostMapping("/findByKey")
//    public ModelAndView findByKey(String keyWord,HttpSession session){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("productList");
//        //根据关键字查询
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.like("name",keyWord);
//        modelAndView.addObject("productList",productService.list(wrapper));
//        modelAndView.addObject("list",productCategoryService.getAllProductCategoryVO());
//        User user = (User)session.getAttribute("user");
//        if(user == null){
//            modelAndView.addObject("cartList",new ArrayList<>());
//        }else{
//            modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
//        }
//        return modelAndView;
//    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productDetail");
        modelAndView.addObject("product",productService.getById(id));
        modelAndView.addObject("list",productCategoryService.getAllProductCategoryVO());
        User user = (User)session.getAttribute("user");
        if(user == null){
            modelAndView.addObject("cartList",new ArrayList<>());
        }else{
            modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        }
        return modelAndView;
    }
}

