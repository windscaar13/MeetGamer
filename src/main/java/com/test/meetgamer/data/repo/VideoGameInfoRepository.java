package com.test.meetgamer.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.meetgamer.data.model.VideoGameInfo;

public interface VideoGameInfoRepository extends JpaRepository<VideoGameInfo, Long> {

}
