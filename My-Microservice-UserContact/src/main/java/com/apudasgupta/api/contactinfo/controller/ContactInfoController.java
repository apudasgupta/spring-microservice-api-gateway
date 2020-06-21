package com.apudasgupta.api.contactinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apudasgupta.api.contactinfo.model.UserContactInfo;
import com.apudasgupta.api.contactinfo.model.UserContactInfos;
import com.apudasgupta.api.contactinfo.service.ContactInfoService;

/**
 * @author Apu Das Gupta
 *
 */

@RestController
@RequestMapping("/contactInfo")
public class ContactInfoController {
	@Autowired
	ContactInfoService userService;

	@GetMapping("/getAll")
	public UserContactInfos contactInfo() {
		return userService.getContactInfo();

	}

	@GetMapping("/getById")
	public UserContactInfo getContactInfoById(@RequestParam Long userId) {
		return userService.getContactInfoById(userId);

	}

}


