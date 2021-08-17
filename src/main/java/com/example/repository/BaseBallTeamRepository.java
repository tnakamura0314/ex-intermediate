package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.BaseballTeam;

/**
 * teamsテーブルを操作するリポジトリ.
 * 
 * @author nakamuratomoya
 *
 */
@Repository
public class BaseBallTeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * BaseballTeamオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<BaseballTeam> BASEBALL_TEAM_LOW_MAPPER = (rs, i) ->{
		
		BaseballTeam baseballTeam = new BaseballTeam();
		baseballTeam.setId(rs.getInt("id"));
		baseballTeam.setLeagueName(rs.getString("league_name"));
		baseballTeam.setTeamName(rs.getString("team_name"));
		baseballTeam.setHeadquarters(rs.getString("headquarters"));
		baseballTeam.setInauguration(rs.getString("inauguration"));
		baseballTeam.setHistory(rs.getString("history"));
		
		return baseballTeam;
	};
	
	/**
	 * 野球チーム情報を発足日の昇順で取得する.
	 * 
	 * @return 野球チーム一覧情報
	 */
	private List<BaseballTeam> findAll(){
		
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration ASC;";
		
		List<BaseballTeam> baseballTeamList = template.query(sql, BASEBALL_TEAM_LOW_MAPPER);
		
		return baseballTeamList;
		
	}
	
	/**
	 * 主キーから野球チームの情報を取得する.
	 * 
	 * @param id ID
	 * @return　主キー対応の野球チーム情報
	 */
	private BaseballTeam load(Integer id) {
		
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id=:id ;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		BaseballTeam baseballTeam = template.queryForObject(sql, param, BASEBALL_TEAM_LOW_MAPPER);
		
		return baseballTeam;
	}

}
