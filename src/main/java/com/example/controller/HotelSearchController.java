package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.HotelSearch;
import com.example.service.HotelSearchService;

@Controller
@RequestMapping("/hotelSearch")
public class HotelSearchController {
	
	@Autowired
	private HotelSearchService service;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index() {
		return "hotel-search";
	}
	
	@RequestMapping("/searchByLessThanPrice")
	public String searchByLessThanPrice(Integer price){
		
		List<HotelSearch> hotelSearchList = service.searchByLessThanPrice(price);
		
		session.setAttribute("hotelSearchList", hotelSearchList);
		
		return "hotel-search-result";
		
	}

}
