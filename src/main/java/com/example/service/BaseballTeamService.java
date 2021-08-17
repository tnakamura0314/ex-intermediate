package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;

/**
 * 野球チーム情報を操作するサービスクラス.
 * 
 * @author nakamuratomoya
 *
 */
@Service
public class BaseballTeamService {
	
	@Autowired
	private BaseballTeamRepository repository;
	
	/**
	 * 野球チーム一覧情報を取得.
	 * 
	 * @return　野球チーム一覧情報
	 */
	public List<BaseballTeam> shwoList(){
		return repository.findAll();
	}
	
	/**
	 * 野球チーム詳細情報を取得
	 * 
	 * @param id　ID 
	 * @return　野球チーム詳細情報
	 */
	public BaseballTeam showDetail(Integer id) {
		return repository.load(id);
	}

}
