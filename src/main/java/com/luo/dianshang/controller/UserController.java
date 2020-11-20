package com.luo.dianshang.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luo.dianshang.entity.User;
import com.luo.dianshang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    //注册
    @PostMapping("/register")
    public String register(User user, Model model){
        boolean result=false;
        try {
            result= userService.save(user);
        } catch (Exception e) {
            model.addAttribute("error",user.getLoginName()+"已存在");
            return "register";
        }
        if (result) return "login";
        return "register";
    }

    //登录
    @PostMapping("/login")
    public String login(String loginName, String password, HttpSession session){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("login_name",loginName);
        wrapper.eq("password",password);
        User user = userService.getOne(wrapper);
        if(user == null){
            return "login";
        }else{
            session.setAttribute("user",user);
            return "redirect:/productCategory/list";
        }
    }
    //注销
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}

