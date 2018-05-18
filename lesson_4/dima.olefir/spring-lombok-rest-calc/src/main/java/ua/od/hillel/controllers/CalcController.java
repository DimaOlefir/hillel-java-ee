package ua.od.hillel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.od.hillel.controllers.dto.Data;
import ua.od.hillel.services.Calc;


@Controller
public class CalcController {
    @Autowired
    Calc calc;

    @GetMapping(value = "/calc/{val1}/{op}/{val2}")
    @ResponseBody
    public Data calc(@PathVariable float val1, @PathVariable String op, @PathVariable float val2,
                     @RequestParam(required = false, defaultValue = "userName") String userName) {

        double res = 0;
        switch (op) {
            case "add":
                res = calc.add(val1, val2);
                break;
            case "div":
                res = calc.div(val1, val2);
                break;
            case "mul":
                res = calc.mul(val1, val2);
                break;
            case "sub":
                res = calc.sub(val1, val2);
                break;
        }

        return new Data(val1, val2, res, op, userName);
    }
}
