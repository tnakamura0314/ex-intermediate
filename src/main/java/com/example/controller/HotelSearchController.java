package com.example.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.HotelSearch;
import com.example.form.HotelSearchForm;
import com.example.service.HotelSearchService;

@Controller
@RequestMapping("/hotelSearch")
public class HotelSearchController {
	
	@Autowired
	private HotelSearchService service;
	
	@ModelAttribute
	public HotelSearchForm setUpForm() {
		return new HotelSearchForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "hotel-search";
	}
	
	@RequestMapping("/searchByLessThanPrice")
	public String searchByLessThanPrice(Integer price, HotelSearchForm hotelSearchForm, Model model){
		
		List<HotelSearch> hotelSearchList = service.searchByLessThanPrice(price);
		BeanUtils.copyProperties(hotelSearchForm, hotelSearchList);
		
		model.addAttribute("hotelSearchList", hotelSearchList);
		
		return "hotel-search";
		
	}

}
