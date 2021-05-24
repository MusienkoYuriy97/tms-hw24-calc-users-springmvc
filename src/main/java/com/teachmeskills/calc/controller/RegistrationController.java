package com.teachmeskills.calc.controller;

import com.teachmeskills.calc.dao.UserDao;
import com.teachmeskills.calc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/reg", name = "RegistrationController")
public class RegistrationController {
    @Autowired
    UserDao userDao;

    @GetMapping
    public String viewPage(Model model,
                           HttpSession session){
        if (session.getAttribute("user") != null){
            return "error";
        }
        model.addAttribute("regUser",new User());
        return "registration";
    }

    @PostMapping
    public String viewPage(@ModelAttribute User regUser,
                           Model model){

        if (regUser.getUsername() == null || regUser.getUsername().trim().equals("") ||
                regUser.getFname() == null || regUser.getFname().trim().equals("") ||
                regUser.getLname() == null || regUser.getLname().trim().equals("") ||
                regUser.getAge() < 10 ||
                regUser.getPassword() == null || regUser.getPassword().trim().equals("")
        ){
            model.addAttribute("message","Enter all field");
            return "registration";
        }

        if (userDao.contains(regUser.getUsername())){
            model.addAttribute("message","User with the same username already exist");
            return "registration";
        }

        userDao.save(regUser);
        return "authorization";
    }
}
