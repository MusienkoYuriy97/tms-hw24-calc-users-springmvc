package com.teachmeskills.calc.controller;

import com.teachmeskills.calc.model.calc.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/calc")
public class CalculatorController {
    @Autowired
    Map<Integer, Action> calcAction;

    @GetMapping
    public String viewPage(@RequestParam(required = false,defaultValue = "0") double x,
                           @RequestParam(required = false,defaultValue = "0") double y,
                           @RequestParam(required = false,defaultValue = "0") int command,
                           Model model){
        double result = 0;
        Action action = null;
        if (calcAction.containsKey(command)){
            action = calcAction.get(command);
            result = action.calculate(x,y);
        }
        model.addAttribute("result",result);
        model.addAttribute("action",action);
        if (action == null){
            model.addAttribute("message","Такой команды не существует");
        }
        return "calculator";
    }
}
