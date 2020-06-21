package com.apudasgupta.api.userdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apudasgupta.api.userdetails.model.UserDetails;
import com.apudasgupta.api.userdetails.model.UserDetailsList;
import com.apudasgupta.api.userdetails.service.UserDetailsService;

/**
 * @author Apu Das Gupta
 *
 */

@RestController
@RequestMapping("/userDetails")
//@Api(tags = "User",description = "Access to User Details")
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	@GetMapping("/getAll")
//	@ApiOperation(value = "Get Details of all users",notes = "All user information",response = UserDetail.class)
	public UserDetailsList getDetailsAll() {
		return userDetailsService.getDetailsAll();
	}
	
	@GetMapping("/getById")
//	@ApiOperation(value = "Find Details by id",notes = "Provide an id to find specific user info",response = UserDetail.class)
	public UserDetails getDetailsById(@RequestParam Long userId) {
		return userDetailsService.getDetailsById(userId);
	}
}


