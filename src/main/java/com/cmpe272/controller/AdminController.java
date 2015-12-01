package com.cmpe272.controller;

import java.util.List;

import com.cmpe272.domain.AccountInfo;
import com.cmpe272.dao.DataPointDAO;
import com.cmpe272.domain.DataPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cmpe272.dao.AccountInfoDAO;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AccountInfoDAO accountInfoDAO;

	@Autowired
	private DataPointDAO dataPointDAO;

	@RequestMapping("/")
	public String homeView(){
		return "adminHome";
	}
	
	@RequestMapping(value = "/userListView",method = RequestMethod.GET)
	public String userListView(){
		return "userListView";
	}
	
	@RequestMapping(value = "/userList",method = RequestMethod.GET)
	@ResponseBody
	public List<AccountInfo> userList(){
		return this.accountInfoDAO.findAll();
	}

	@RequestMapping(value = "/user/{id}/delete",method = RequestMethod.GET)
	@ResponseBody
	public List<AccountInfo> removeUser(@PathVariable("id")String id){
		this.accountInfoDAO.deleteById(id);
		return this.userList();
	}

	@RequestMapping("/sensorListView")
	public String sensorListView(){
		return "sensorListView";
	}

	@RequestMapping("/sensorDataListView")
	public String sensorDataListView(){
		return "sensorDataListView";
	}

	@RequestMapping(value = "/sensor/{id}/data",method = RequestMethod.GET)
	@ResponseBody
	public List<DataPoint> getDataBySensorId(@PathVariable("id")String id){
		return this.dataPointDAO.findAllBySensorId(id);
	}

	@ExceptionHandler(value = {Exception.class})
	@ResponseBody
	public String exceptionHandler(Exception exception){
		return exception.getMessage();
	}
	
}
