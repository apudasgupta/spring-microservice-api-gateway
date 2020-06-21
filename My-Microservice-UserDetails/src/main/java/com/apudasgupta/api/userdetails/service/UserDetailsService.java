package com.apudasgupta.api.userdetails.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apudasgupta.api.userdetails.model.UserContactInfo;
import com.apudasgupta.api.userdetails.model.UserDetails;
import com.apudasgupta.api.userdetails.model.UserDetailsList;
import com.apudasgupta.api.userdetails.model.UserInfo;
import com.apudasgupta.api.userdetails.model.UserInfos;

/**
 * @author Apu Das Gupta
 *
 */

@Service
public class UserDetailsService {
	@Autowired
	RestTemplate restTemplate;

	public UserDetailsList getDetailsAll() {
		List<UserDetails> userDetails = new ArrayList<UserDetails>();
		String urlUserInfos = "http://user-info-service/userInfo/getAll";
		UserInfos userInfos = restTemplate.getForObject(urlUserInfos, UserInfos.class);
		List<UserInfo> userInfoList = userInfos.getUserInfoList();

		for (Iterator iterator = userInfoList.iterator(); iterator.hasNext();) {
			UserInfo userInfo = (UserInfo) iterator.next();
			UserContactInfo userContactInfo = restTemplate.getForObject("http://user-contact-service/contactInfo/getById?userId=" + userInfo.getId(), UserContactInfo.class);
			
			UserDetails userDetail = new UserDetails();
			userDetail.setId(userInfo.getId());
			userDetail.setName(userInfo.getName());
			userDetail.setEmail(userInfo.getEmail());
			userDetail.setPhone(userContactInfo.getPhone());
			userDetail.setAddress(userContactInfo.getAddress());
			userDetails.add(userDetail);
		}
		UserDetailsList detailsList=new UserDetailsList();
		detailsList.setUserDetailsList(userDetails);
		return detailsList;

	}

	public UserDetails getDetailsById(Long userId) {
//		String url="http://localhost:8091/user/getById?userId=2";
		String urlUserInfo = "http://user-info-service/userInfo/getById?userId=" + userId;
		UserInfo userInfo = restTemplate.getForObject(urlUserInfo, UserInfo.class);

		String urlUserContactInfo = "http://user-contact-service/contactInfo/getById?userId=" + userId;
		UserContactInfo userContactInfo = restTemplate.getForObject(urlUserContactInfo, UserContactInfo.class);

		UserDetails userDetail = new UserDetails();
		userDetail.setId(userInfo.getId());
		userDetail.setName(userInfo.getName());
		userDetail.setEmail(userInfo.getEmail());
		userDetail.setPhone(userContactInfo.getPhone());
		userDetail.setAddress(userContactInfo.getAddress());

		
		return userDetail;
	}
}


