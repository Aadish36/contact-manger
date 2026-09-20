package com.smart.contact.manger.Controller;


import com.mysql.cj.protocol.Message;
import com.smart.contact.manger.Entity.user;
import com.smart.contact.manger.Reposetery.userrepo;
import com.smart.contact.manger.helper.message;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@Controller
public class Homecontroller {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public userrepo  userrepo;
 @GetMapping("/home")
   public String home(Model model) {
     model.addAttribute("title", "Home");
     return "home";
   }
   @RequestMapping("/about")
public String about(Model model){
     model.addAttribute("title", "About");
     return "about";
}
@RequestMapping("/signup")
public String signup(Model model){
        model.addAttribute("title","Register-Smart contact manager ");
        model.addAttribute("user",new user());
        return "signup";
    }
    @RequestMapping(value = "signup",method = RequestMethod.POST)
    public String registeruser(@ModelAttribute("user") user user,BindingResult result1, @RequestParam(value="agreement",defaultValue = "false")boolean agreement, Model model
    , HttpSession session){
     try {
         if (!agreement){
             System.out.println("You are not agreed the t&c");
             throw  new Exception("You are not agreed the t&c");
         }
         if (result1.hasErrors()){
             System.out.println("Error"+ result1.toString());
             model.addAttribute("user",user);
             return "signup";
         }
         user.setRole("ROLE_USER");
         user.isEnabled(true);
         user.setImageurl("default.png");
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         System.out.println("Agreement:"+agreement);
         System.out.println("User"+user );
         user result = this.userrepo.save(user) ;
         model.addAttribute("user",new user());
         session.setAttribute("message", new message("Successfuly Registered !!", "alert-success") {

         });
     } catch (Exception e) {
         e.printStackTrace();
         model.addAttribute("user",user);
         session.setAttribute("message",new message("So,ting wemt wrong"+e.getMessage(),"alert-error"));
     }
     return "signup";
    }



}
