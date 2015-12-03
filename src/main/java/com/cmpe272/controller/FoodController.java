package com.cmpe272.controller;

import com.cmpe272.domain.Food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yutao on 12/2/15.
 */
@Controller
@RequestMapping("/food")
public class FoodController {

    @RequestMapping("/")
    @ResponseBody
    public List<Food> getAllFood() {
        return null;
    }

    @RequestMapping("/expired")
    @ResponseBody
    public List<Food> getAllExpiredFood() {
        return null;
    }

    @RequestMapping("/expired/{days}")
    @ResponseBody
    public List<Food> getAllExpiredFoodByDay() {
        return null;
    }

}
