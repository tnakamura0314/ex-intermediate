package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;

/**
 * 野球チームの情報を操作するコントローラー.
 * 
 * @author nakamuratomoya
 *
 */
@Controller
@RequestMapping("/baseballTeam")
public class BaseballTeamController {
	
	@Autowired
	private BaseballTeamService service;
	
	/**
	 * 野球チーム一覧情報を取得する.
	 * 
	 * @param model requestスコープ
	 * @return 野球チーム一覧情報
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {

		List<BaseballTeam> baseballTeamList = service.shwoList();

		model.addAttribute("baseballTeamList", baseballTeamList);

		return "show-list";

	}

	/**
	 * 野球チーム詳細情報を取得する.
	 * 
	 * @param id    ID
	 * @param model requestスコープ
	 * @return 野球チーム詳細情報
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {

		BaseballTeam baseballTeam = service.showDetail(id);

		model.addAttribute("baseballTeam", baseballTeam);

		return "show-detail";

	}

}
