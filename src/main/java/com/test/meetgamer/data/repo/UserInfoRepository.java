package com.test.meetgamer.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.meetgamer.data.model.*;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	
	public List<UserInfo> findByUserNameContaining(String userName);
	
	public UserInfo findByUserNickNameContaining(String userNickName);
	
	public List<UserInfo> findByRegionContaining(String region);
	
	public List<UserInfo> findByUserGamePrefList_FavGameAndUserGamePrefList_SkillLevel(String favGame, String skillLevel);

}
