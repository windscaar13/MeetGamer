package com.test.meetgamer.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_game_pref")
public class UserGamePref {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "fav_game")
	private String favGame;
	@Column(name = "skill_level")
	private String skillLevel;
	
	public UserGamePref() {
		
	}
	
	public UserGamePref(String favGame, String skillLevel) {
		super();
		this.favGame = favGame;
		this.skillLevel = skillLevel;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFavGame() {
		return favGame;
	}
	public void setFavGame(String favGame) {
		this.favGame = favGame;
	}
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

}
