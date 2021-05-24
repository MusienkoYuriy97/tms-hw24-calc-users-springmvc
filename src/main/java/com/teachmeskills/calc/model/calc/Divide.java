package com.teachmeskills.calc.model.calc;

import com.teachmeskills.calc.dao.OperationDao;
import com.teachmeskills.calc.model.Operation;
import com.teachmeskills.calc.model.User;
import com.teachmeskills.calc.util.ConsoleReader;
import com.teachmeskills.calc.util.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Divide implements Action {
    @Autowired
    private OperationDao operationDao;

    @Override
    public double calculate(double x, double y, User sessionUser) {
        double result = x / y;
        operationDao.add(new Operation(x,y,result,"Деление",sessionUser));
        return result;
    }
}