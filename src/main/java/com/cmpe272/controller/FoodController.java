package com.cmpe272.controller;

import com.cmpe272.dao.FoodDAO;
import com.cmpe272.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yutao on 12/2/15.
 */
@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodDAO foodDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Food> getAllFood() {
        return foodDAO.findAll();
    }

    @RequestMapping(value = "/expired", method = RequestMethod.GET)
    @ResponseBody
    public List<Food> getAllExpiredFood() {
        return null;
    }

    @RequestMapping(value = "/expired/{days}", method = RequestMethod.GET)
    @ResponseBody
    public List<Food> getAllExpiredFoodByDay() {
        return null;
    }

    @RequestMapping(value = "/expired/{days}/{discount}", method = RequestMethod.POST)
    @ResponseBody
    public String setStrategy() {
        return "SUCCESS";
    }
}
