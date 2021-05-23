package com.teachmeskills.calc.controller;

import com.teachmeskills.calc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthorizationController {
    @Autowired
    UserDao userDao;

    @GetMapping
    public String viewPage(String username,
                           String password,
                           Model model,
                           HttpSession httpSession){
        if (userDao.contains(username,password)){
            httpSession.setAttribute("user", userDao.getUserByUsername(username));
            return "calculator";
        }

        model.addAttribute("amessage","Wrong login or password");
        return "authorization";
    }
}
