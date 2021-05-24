package com.teachmeskills.calc.controller;

import com.teachmeskills.calc.dao.OperationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    OperationDao operationDao;

    @GetMapping
    public String viewPage(Model model,
                           HttpSession session){
        if (session.getAttribute("user") == null){
            return "error";
        }
        if (!operationDao.getOperations().isEmpty()){
            model.addAttribute("operations",operationDao.getOperations());
        }
        return "history";
    }
}
