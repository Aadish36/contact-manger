package com.smart.contact.manger.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RequestMapping("/user")
public class Usercontroller {
    @RequestMapping("/Index")
    public String Dhasboard(){
        return "normal/User_Dhasboard";
    }
}
