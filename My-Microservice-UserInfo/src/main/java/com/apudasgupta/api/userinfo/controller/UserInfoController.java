package com.apudasgupta.api.userinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apudasgupta.api.userinfo.model.UserInfo;
import com.apudasgupta.api.userinfo.model.UserInfos;
import com.apudasgupta.api.userinfo.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Apu Das Gupta
 *
 */

@Slf4j
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	@Value("${server.port}")
	private String serverPort;

	@Autowired
	UserInfoService userInfoService;

	@GetMapping("/getAll")
	public UserInfos getInfo() {
		log.info("Getting all user info from server @ {}", serverPort);
		return userInfoService.getInfo();
	}

	@GetMapping("/getById")
	public UserInfo getById(@RequestParam Long userId) {
		return userInfoService.getById(userId);
	}
}
