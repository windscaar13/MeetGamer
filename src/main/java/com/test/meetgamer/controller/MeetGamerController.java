package com.test.meetgamer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.meetgamer.data.model.GamerSkill;
import com.test.meetgamer.data.model.UserGamePref;
import com.test.meetgamer.data.model.UserInfo;
import com.test.meetgamer.data.model.VideoGameInfo;
import com.test.meetgamer.service.MeetGamerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Validated
@RequestMapping("api/")
public class MeetGamerController {
	
	@Autowired
	private MeetGamerService meetGamerService;
	
	@PostMapping("enrollGamer")
	public ResponseEntity<UserInfo> enrollGamer(@RequestBody UserInfo userInfo){
		try {
			UserInfo _userInfo = meetGamerService.createUserInfo(userInfo);
			return new ResponseEntity<>(_userInfo, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@PutMapping("addUserCredits/{id}")
	public ResponseEntity<UserInfo> addUserCredits(@PathVariable("id") long id, @RequestBody UserInfo userInfo) {
		Optional<UserInfo> userInfoData = meetGamerService.findById(id);

		if (userInfoData.isPresent()) {
			UserInfo _userInfo = userInfoData.get();
			_userInfo.setUserCredits(userInfo.getUserCredits());
			return new ResponseEntity<>(meetGamerService.createUserInfo(_userInfo), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("searchGamers/{skill}/{favGame}/{region}")
	public ResponseEntity<List<UserInfo>> searchGamers(@PathVariable("skill") String skill, @PathVariable("favGame") String favGame, @PathVariable("region") String region){
		try {
			List<UserInfo> userInfoList = this.meetGamerService.searchUserInfo(skill, favGame, region);
			return new ResponseEntity<>(userInfoList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("getGamerWithMaxCredit/{favGame}/{skill}")
	public ResponseEntity<UserInfo> getGamerWithMaxCredit( @PathVariable("favGame") String favGame, @PathVariable("skill") String skill){
		try {
			return new ResponseEntity<>(this.meetGamerService.getGamerWithMaxCredit(favGame,skill), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("userinfo")
	public List<UserInfo> getAllUserInfo(){
		return this.meetGamerService.getAllUserInfo();
	}
	
	@GetMapping("videogameinfo")
	public List<VideoGameInfo> getAllVideoGameInfo(){
		return this.meetGamerService.getAllVideoGameInfo();
	}
	
	@GetMapping("gamerskill")
	public List<GamerSkill> getAllGamerSkills(){
		return this.meetGamerService.getAllGamerSkills();
	}
	
	@GetMapping("usergamepref")
	public List<UserGamePref> getAllUserGamePref(){
		return this.meetGamerService.getAllUserGamePref();
	}

}
