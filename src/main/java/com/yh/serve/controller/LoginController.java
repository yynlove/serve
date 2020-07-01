package com.yh.serve.controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {


    @PostMapping
    public String login(@RequestParam Map<String,Object> map){
        System.out.println(map.toString());
        return "200";
    }


}
