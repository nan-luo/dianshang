package com.luo.dianshang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 南磊
 * @date 2020/5/18 17:22
 * @Description
 */
@Controller
public class RedirectHandler {

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    //redirect 重定向  路径会变
    //forward 转发 路径不变

    @GetMapping("/")
    public String main(){
        return "redirect:/productCategory/list";
    }
}
