package com.test.meetgamer.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.meetgamer.data.model.UserGamePref;


public interface UserGamePrefRepository extends JpaRepository<UserGamePref, Long>{

}
