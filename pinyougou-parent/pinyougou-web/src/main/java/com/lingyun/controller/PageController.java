package com.lingyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 张俊荣 15835910851
 * @Description //TODO
 * @Date 2019/9/3 21:41
 * @Param
 * @return
 **/
@Controller
@RequestMapping("page")
public class PageController {
    @RequestMapping("toMain")
    public String toMain(){
        return "jsp/main";
    }
}
