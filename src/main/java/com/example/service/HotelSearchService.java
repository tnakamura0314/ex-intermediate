package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.HotelSearch;
import com.example.repository.HotelSearchRepository;

/**
 * ホテル情報を操作するサービスクラス.
 * 
 * @author nakamuratomoya
 *
 */
@Service
public class HotelSearchService {

	@Autowired
	private HotelSearchRepository repository;

	/**
	 * 指定価格から該当のホテル情報を取得する.
	 * 
	 * @param price 価格
	 * @return 該当のホテル情報
	 */
	public List<HotelSearch> searchByLessThanPrice(Integer price) {

		if (price == null) {
			return repository.findAll();
		}

		return repository.findByPrice(price);
	}
}
