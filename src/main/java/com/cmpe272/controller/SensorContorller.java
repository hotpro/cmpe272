package com.cmpe272.controller;

import com.cmpe272.dao.DataPointDAO;
import com.cmpe272.dao.SensorDAO;
import com.cmpe272.domain.DataPoint;
import com.cmpe272.domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiaofengli on 11/30/15.
 */

@Controller
@RequestMapping("/sensor")
public class SensorContorller {

    @Autowired
    private DataPointDAO dataPointDAO;

    @Autowired
    private SensorDAO sensorDAO;

    @RequestMapping(value = "/uploaddata", method = RequestMethod.POST)
    @ResponseBody
    public void upload(@RequestBody DataPoint dataPoint) {
        dataPointDAO.add(dataPoint);
    }


    @RequestMapping(value = "/status/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String status(@RequestParam("id")String id) {
        Sensor sensor = this.sensorDAO.findById(id);
        if(sensor!=null){
            return sensor.getState();
        }
        return "";
    }


    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public String exceptionHandler(Exception exception){
        return exception.getMessage();
    }

}
