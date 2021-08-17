package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.HotelSearch;

/**
 * hotelsテーブルを操作するリポジトリ.
 * 
 * @author nakamuratomoya
 *
 */
@Repository
public class HotelSearchRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	/**
	 * HotelSearchオブジェクトを生成するローマッパー.
	 * 
	 */
	private static final RowMapper<HotelSearch> HOTEL_SEARCH_ROW_MAPPER = (rs, i) -> {
		
		HotelSearch hotelSearch = new HotelSearch();
		hotelSearch.setId(rs.getInt("id"));
		hotelSearch.setAreaName(rs.getString("area_name"));
		hotelSearch.setHotelName(rs.getString("hotel_name"));
		hotelSearch.setAddress(rs.getString("address"));
		hotelSearch.setNearestStation(rs.getString("nearest_station"));
		hotelSearch.setPrice(rs.getInt("price"));
		hotelSearch.setParking(rs.getString("parking"));
		
		return hotelSearch;
		
	};
	
	/**
	 * 指定価格から該当のホテル情報を検索する.
	 * 
	 * @param price 価格
	 * @return 該当するホテル情報.
	 */
	public List<HotelSearch> findByPrice(Integer price){
		
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price ;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		
		List<HotelSearch> hotelSearchList = template.query(sql, param, HOTEL_SEARCH_ROW_MAPPER);
		
		return hotelSearchList;
	}

}
