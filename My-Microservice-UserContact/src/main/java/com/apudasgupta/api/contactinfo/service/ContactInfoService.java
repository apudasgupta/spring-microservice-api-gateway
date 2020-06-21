package com.apudasgupta.api.contactinfo.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.apudasgupta.api.contactinfo.model.UserContactInfo;
import com.apudasgupta.api.contactinfo.model.UserContactInfos;

/**
 * @author Apu Das Gupta
 *
 */

@Service
public class ContactInfoService {
	List<UserContactInfo> userContactList;

	@PostConstruct
	private void initUserInfo() {
		userContactList = Arrays.asList(new UserContactInfo(1L, "+8801111111111", "address of usre id one"),
				new UserContactInfo(2L, "+8802222222222", "address of usre id two"));
		System.out.println("==> userContactInfo: " + userContactList.toString());
	}

	public UserContactInfos getContactInfo() {
		UserContactInfos userContactInfos = new UserContactInfos();
		userContactInfos.setUserContactInfoList(userContactList);
		return userContactInfos;
	}

	public UserContactInfo getContactInfoById(Long userId) {

		return userContactList.stream().filter(user -> (user.getUserId() == userId)).findAny().orElse(null);

	}
}


