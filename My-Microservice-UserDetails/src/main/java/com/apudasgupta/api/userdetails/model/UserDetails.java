package com.apudasgupta.api.userdetails.model;

import lombok.Data;

/**
 * @author Apu Das Gupta
 *
 */

@Data
//@ApiModel(description = "Details about the user")
public class UserDetails {
//	@ApiModelProperty(notes = "The unique id of the User")
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String address;
	
	
	
	
	
}
