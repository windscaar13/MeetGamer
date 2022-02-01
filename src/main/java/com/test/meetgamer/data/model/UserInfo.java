package com.test.meetgamer.data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_info")
public class UserInfo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Column(name = "user_name")
	private String userName;
	@NotNull
	@Column(name = "user_nick_name")
	private String userNickName;
	private String gender;
	@NotNull
	private String region;
	@Column(name = "user_credits")
	private long userCredits;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name = "game_pref_id", referencedColumnName = "id")
	private Set<UserGamePref> userGamePrefList = new HashSet<>();
	
	public UserInfo() {
		
	}
	
	public UserInfo(String name, String nickName, String gender, String region) {
		super();
		this.userName = name;
		this.userNickName = nickName;
		this.gender = gender;
		this.region = region;
	}
	
	public long getUserCredits() {
		return userCredits;
	}

	public void setUserCredits(long userCredits) {
		this.userCredits = userCredits;
	}

	public void addUserGamePref(UserGamePref userGamePref) {
		userGamePrefList.add(userGamePref);
	}
	
	public Set<UserGamePref> getUserGamePrefList() {
		return userGamePrefList;
	}

	public void setUserGamePrefList(Set<UserGamePref> userGamePrefList) {
		this.userGamePrefList = userGamePrefList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	

}
