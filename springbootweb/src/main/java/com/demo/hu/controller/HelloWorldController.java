package com.demo.hu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping(value = "/")
    public String index(ModelMap map){
        //加入一个属性，用来在模板中读取
        map.addAttribute("host","http://blog.didispace.com");
        //return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello World";
    }
}
