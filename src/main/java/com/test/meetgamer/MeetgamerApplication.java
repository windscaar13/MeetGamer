package com.test.meetgamer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.meetgamer.data.model.GamerSkill;
import com.test.meetgamer.data.model.UserGamePref;
import com.test.meetgamer.data.model.UserInfo;
import com.test.meetgamer.data.model.VideoGameInfo;
import com.test.meetgamer.data.repo.UserInfoRepository;
import com.test.meetgamer.service.MeetGamerService;

@SpringBootApplication
public class MeetgamerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MeetgamerApplication.class, args);
	}
	
	@Autowired
	private MeetGamerService meetGamerService;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	 
	@Override
	public void run(String... args) throws Exception {
		//Adding GameSkill Master data to H2 DB
		this.meetGamerService.saveGamerSkill(new GamerSkill("Noob"));
		this.meetGamerService.saveGamerSkill(new GamerSkill("Pro"));
		this.meetGamerService.saveGamerSkill(new GamerSkill("Invincible"));
		//Adding Video Game Info Master data to H2 DB
		this.meetGamerService.saveVideoGameInfo(new VideoGameInfo("Elden Ring", "Action role-playing"));
		this.meetGamerService.saveVideoGameInfo(new VideoGameInfo("Bloodborne", "Action role-playing"));
		this.meetGamerService.saveVideoGameInfo(new VideoGameInfo("Monster Hunter World", "Action role-playing"));
		this.meetGamerService.saveVideoGameInfo(new VideoGameInfo("Destiny 2", "FPS"));
		this.meetGamerService.saveVideoGameInfo(new VideoGameInfo("Halo Infinite", "FPS"));
		this.meetGamerService.saveVideoGameInfo(new VideoGameInfo("Borderlands 3", "FPS"));
		this.meetGamerService.saveVideoGameInfo(new VideoGameInfo("Valorant", "FPS"));
		this.meetGamerService.saveVideoGameInfo(new VideoGameInfo("Call of Duty: Warzone", "Battle royale"));
		this.meetGamerService.saveVideoGameInfo(new VideoGameInfo("Fortnite", "Battle royale"));
		this.meetGamerService.saveVideoGameInfo(new VideoGameInfo("Apex Legends", "Battle royale"));
		//Adding Default User Info to H2 DB
		UserGamePref userGamePref1 = new UserGamePref("Monster Hunter World","Pro");
		UserGamePref userGamePref2 = new UserGamePref("Bloodborne","Pro");
		UserGamePref userGamePref3 = new UserGamePref("Call of Duty: Warzone","Noob");
		UserInfo userInfo = new UserInfo("Selva","Windscaar","Male","ASIA");
		userInfo.getUserGamePrefList().add(userGamePref1);
		userInfo.getUserGamePrefList().add(userGamePref2);
		userInfo.getUserGamePrefList().add(userGamePref3);
		this.meetGamerService.createUserInfo(userInfo);
		
		userGamePref1 = new UserGamePref("Monster Hunter World","Noob");
		userGamePref2 = new UserGamePref("Bloodborne","Pro");
		userGamePref3 = new UserGamePref("Call of Duty: Warzone","Pro");
		userInfo = new UserInfo("Suraj","Sleakiller","Male","ASIA");
		userInfo.getUserGamePrefList().add(userGamePref1);
		userInfo.getUserGamePrefList().add(userGamePref2);
		userInfo.getUserGamePrefList().add(userGamePref3);
		this.meetGamerService.createUserInfo(userInfo);
		
		//System.out.println("Find by favGame: "+userInfoRepository.findByUserGamePrefList_FavGameAndUserGamePrefList_SkillLevel("Bloodborne", "Pro").get(0).getUserNickName());
	}

}
