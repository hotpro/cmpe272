package com.cmpe272.controller;

import com.cmpe272.dao.FoodDAO;
import com.cmpe272.domain.DiscountNum;
import com.cmpe272.domain.DonationHistory;
import com.cmpe272.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Date;
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
        Calendar cal = getCalendar();
        Date start = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 21);
        Date end = cal.getTime();
        List<Food> list = foodDAO.findByRange(start, end);
        return list;
    }

    private Calendar getCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    @RequestMapping(value = "/expired/{days}", method = RequestMethod.GET)
    @ResponseBody
    public List<Food> getAllExpiredFoodByDay(@PathVariable int days) {
        Calendar cal = getCalendar();
        cal.add(Calendar.DAY_OF_MONTH, days);
        Date end = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, -7);
        Date start = cal.getTime();
        List<Food> list = foodDAO.findByRange(start, end);
        return list;
    }

    @RequestMapping(value = "/expired/{days}/{discount}", method = RequestMethod.POST)
    @ResponseBody
    public String setStrategy(@PathVariable int days, @PathVariable int discount) {
        Calendar cal = getCalendar();
        cal.add(Calendar.DAY_OF_MONTH, days);
        Date end = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, -7);
        Date start = cal.getTime();
        boolean result = foodDAO.setFoodDiscount(start, end, discount * 1.0 / 10);

        return result ? "SUCCESS" : "FAIL";
    }

    @RequestMapping(value = "/analysis/donation", method = RequestMethod.GET)
    @ResponseBody
    public DonationHistory getDonationHistory() {
        DonationHistory donationHistory = new DonationHistory();
        donationHistory.years = new String[]{"2015", "2016", "2017", "2018", "2019"};
        donationHistory.numbers = new long[] {1000, 800, 900, 700, 50};
        int[] nums = {2015, 2016, 2017, 2018, 2019};
        donationHistory.years = new String[nums.length];
        donationHistory.numbers = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            donationHistory.years[i] = String.valueOf(nums[i]);
            donationHistory.numbers[i] = getDonationCount(nums[i]);
        }

        return donationHistory;
    }

    @RequestMapping(value = "/analysis/discount/top", method = RequestMethod.GET)
    @ResponseBody
    public List<DiscountNum> getTopDiscount() {
        return foodDAO.getTop5Discount();
    }


    private long getDonationCount(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date start = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        Date end = cal.getTime();
        return foodDAO.getDonationCount(start, end);
    }



//    @RequestMapping(value = "/analysis/donation", method = RequestMethod.GET)
//    @ResponseBody
//    public DonationHistory getDonationHistory() {
//        DonationHistory donationHistory = new DonationHistory();
//        donationHistory.years = new String[]{"2015", "2016", "2017", "2018", "2019"};
//        donationHistory.numbers = new int[] {1000, 800, 900, 700, 50};
//        return donationHistory;
//    }

    @RequestMapping(value = "/discount", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteDiscount() {

    }
}
