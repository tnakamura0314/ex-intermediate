package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.HotelSearch;
import com.example.repository.HotelSearchRepository;

@Service
public class HotelSearchService {
	
	@Autowired
	private HotelSearchRepository repository;
	
	public List<HotelSearch> searchByLessThanPrice(Integer price){
		return repository.findByPrice(price);
	}

}
