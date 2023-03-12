package com.gamedata.task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gamedata.task.models.Bet;
import com.gamedata.task.serviceImpl.BetServiceImpl;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	BetServiceImpl serviceImpl;

	@GetMapping("/home")
	public String listAllData() {
		
		return "Home";
	
	}
	
	@GetMapping("/Search")
	public String SearchData() {
		
		return "Search";
	
	}
}
