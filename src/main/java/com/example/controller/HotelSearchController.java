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

/**
 * ホテルの情報を操作するコントローラー.
 * 
 * @author nakamuratomoya
 *
 */
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
	
	/**
	 * 指定価格から該当のホテル情報を取得する.
	 * 
	 * @param price 価格
	 * @param hotelSearchForm　フォームクラス
	 * @param model　requestスコープ
	 * @return　該当のホテル情報
	 */
	@RequestMapping("/searchByLessThanPrice")
	public String searchByLessThanPrice(Integer price, HotelSearchForm hotelSearchForm, Model model){
		
		List<HotelSearch> hotelSearchList = service.searchByLessThanPrice(price);
		BeanUtils.copyProperties(hotelSearchForm, hotelSearchList);
		
		model.addAttribute("hotelSearchList", hotelSearchList);
		
		return "hotel-search";
		
	}

}
