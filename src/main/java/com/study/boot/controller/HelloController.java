package com.study.boot.controller;

import com.study.boot.bean.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//@RestController
@Controller
public class HelloController {
    @Autowired
    Pet tomcatPet;
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Springboot2";
    }

    @GetMapping("/pet")
    public Pet pet() {
        return tomcatPet;
    }

    @GetMapping("/IMG_3527.JPG")
    public String test01() {
        return "test01";
    }

    @GetMapping("/pv/pet/{name}")
    public Map<String, Object> getPet(@PathVariable String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> headerMap) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("headerMap", headerMap);
        return map;
    }

    // 矩阵变量
    // 前提需要在MyConfig配置类中重写configurePathMatch
    ///mv/pet/info;name=tomcat;weight=20
    @GetMapping("/mv/pet/{path}")
    public Map<String, Object> getPet(@MatrixVariable String name,
                                      @MatrixVariable Double weight,
                                      @PathVariable String path) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("weight", weight);
        map.put("path", path);
        return map;
    }

    ///mv/pet/cat;weight=5.5/dog;weight=10.2
    @GetMapping("/mv2/pet/{catName}/{dogName}")
    public Map<String, Object> getPet(@MatrixVariable(value = "weight", pathVar = "catName") Double catWeight,
                                      @MatrixVariable(value = "weight", pathVar = "dogName") Double dogWeight) {
        Map<String, Object> map = new HashMap<>();
        map.put("catWeight", catWeight);
        map.put("dogWeight", dogWeight);
        return map;
    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        map.put("hello", "world666");
        model.addAttribute("world", "hello666");
        request.setAttribute("message", "HelloWorld");

        Cookie cookie = new Cookie("C1", "V1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);

        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(
            @RequestAttribute(value = "msg", required = false) String msg,
            @RequestAttribute(value = "code", required = false) Integer code,
            HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        map.put("reqMethod_msg", msg1);
        map.put("annotation_msg", msg);
        map.put("hello", hello);
        map.put("world", world);
        map.put("message", message);

        return map;
    }
}
