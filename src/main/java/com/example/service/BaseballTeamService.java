package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;

@Service
public class BaseballTeamService {
	
	@Autowired
	private BaseballTeamRepository repository;
	
	public List<BaseballTeam> findAll(){
		return repository.findAll();
	}
	
	public BaseballTeam load(Integer id) {
		return repository.load(id);
	}

}
