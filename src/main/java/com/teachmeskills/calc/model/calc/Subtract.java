package com.teachmeskills.calc.model.calc;

import com.teachmeskills.calc.dao.OperationDao;
import com.teachmeskills.calc.model.Operation;
import com.teachmeskills.calc.util.ConsoleReader;
import com.teachmeskills.calc.util.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Subtract implements Action {
    @Autowired
    private OperationDao operationDao;

    @Override
    public double calculate(double x, double y) {
        double result = x - y;
        operationDao.add(new Operation(x,y,result,"Вычитание"));
        return result;
    }
}