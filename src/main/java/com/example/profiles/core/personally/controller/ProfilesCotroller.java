package com.example.profiles.core.personally.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProfilesCotroller {
    @GetMapping("/profile")
    public String displayProfile(){
        System.out.printf("oke");
        return "Index.html";
    }
    @GetMapping("/profile-edit")
    public String helloHome(){
        return "update";
    }
}
