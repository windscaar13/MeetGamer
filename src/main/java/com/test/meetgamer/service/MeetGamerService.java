package com.test.meetgamer.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.meetgamer.data.model.GamerSkill;
import com.test.meetgamer.data.model.UserGamePref;
import com.test.meetgamer.data.model.UserInfo;
import com.test.meetgamer.data.model.VideoGameInfo;
import com.test.meetgamer.data.repo.GamerSkillRepository;
import com.test.meetgamer.data.repo.UserGamePrefRepository;
import com.test.meetgamer.data.repo.UserInfoRepository;
import com.test.meetgamer.data.repo.VideoGameInfoRepository;

@Service
@Transactional
public class MeetGamerService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private GamerSkillRepository gamerSkillRepository;
	
	@Autowired
	private VideoGameInfoRepository videoGameInfoRepository;
	
	@Autowired
	private UserGamePrefRepository userGamePrefRepository;
	
	public UserInfo createUserInfo(UserInfo userInfo) {
		UserInfo _userInfo = userInfoRepository.save(userInfo);
		return _userInfo;
	}
	
	public Optional<UserInfo> findById(long id) {
		return userInfoRepository.findById(id);
	}
	
	public List<UserInfo> searchUserInfo(String skill, String favGame, String region) throws Exception {
		List<UserInfo> _userInfoList = new ArrayList<>();
		List<UserInfo> userInfoList = userInfoRepository
				.findByUserGamePrefList_FavGameAndUserGamePrefList_SkillLevel(favGame, skill);
		if (userInfoList != null && !userInfoList.isEmpty()) {
			for (UserInfo userInfo : userInfoList) {
				if (region.equals(userInfo.getRegion())) {
					_userInfoList.add(userInfo);
				}
			}
		}
		return _userInfoList;
	}
	
	public UserInfo getGamerWithMaxCredit(String favGame, String skill) throws Exception{
		UserInfo _userInfo = new UserInfo();
		List<UserInfo> userInfoList = userInfoRepository.findByUserGamePrefList_FavGameAndUserGamePrefList_SkillLevel(favGame, skill);
		if(userInfoList!=null && !userInfoList.isEmpty())
		_userInfo = userInfoList.stream().max(Comparator.comparingLong(UserInfo::getUserCredits)).get();
		return _userInfo;
	}
	
	public GamerSkill saveGamerSkill(GamerSkill gamerSkill) {
		GamerSkill _gamerSkill = 
				gamerSkillRepository.save(gamerSkill);
		return _gamerSkill;
	}
	
	public VideoGameInfo saveVideoGameInfo(VideoGameInfo videoGameInfo) {
		VideoGameInfo _videoGameInfo = videoGameInfoRepository.save(videoGameInfo);
		return _videoGameInfo;
	}
	
	public UserGamePref saveUserGamePref(UserGamePref userGamePref) {
		UserGamePref _userGamePref = userGamePrefRepository.save(userGamePref);
		return _userGamePref;
	}
	
	public List<UserInfo> getUserInfoByName(String userName) {
		return this.userInfoRepository.findByUserNameContaining(userName);
	}
	
	public UserInfo getUserInfoByNickName(String userNickName) {
		return this.userInfoRepository.findByUserNickNameContaining(userNickName);
	}
	
	public List<UserInfo> getAllUserInfo(){
		return this.userInfoRepository.findAll();
	}
	
	public List<GamerSkill> getAllGamerSkills(){
		return this.gamerSkillRepository.findAll();
	}
	
	public List<VideoGameInfo> getAllVideoGameInfo(){
		return this.videoGameInfoRepository.findAll();
	}
	
	public List<UserGamePref> getAllUserGamePref(){
		return this.userGamePrefRepository.findAll();
	}

}
