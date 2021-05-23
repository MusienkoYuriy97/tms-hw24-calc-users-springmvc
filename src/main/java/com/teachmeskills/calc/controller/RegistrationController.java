package com.teachmeskills.calc.controller;

import com.teachmeskills.calc.dao.UserDao;
import com.teachmeskills.calc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reg")
public class RegistrationController {
    @Autowired
    UserDao userDao;

    @GetMapping
    public String viewPage(){
        return "registration";
    }

    @PostMapping
    public String viewPage(String username,
                           String fname,
                           String lname,
                           @RequestParam(required = false,defaultValue = "0") int age,
                           String password,
                           Model model){
        if (username == null || username.trim().equals("") ||
                fname == null || fname.trim().equals("") ||
                lname == null || lname.trim().equals("") ||
                age < 10 ||
                password == null || password.trim().equals("")
        ){
            model.addAttribute("message","Enter all field");
            return "registration";
        }

        if (userDao.contains(username)){
            model.addAttribute("message","User with the same username already exist");
            return "registration";
        }

        User user = new User(0,username,fname,lname,age,password);
        userDao.save(user);
        return "authorization";
    }
}
