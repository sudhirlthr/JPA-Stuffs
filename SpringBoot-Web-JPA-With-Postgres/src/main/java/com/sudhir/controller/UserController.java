/**
 * 
 */
package com.sudhir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.model.Userdb;
import com.sudhir.repository.UserRepository;

/**
 * @author sudhirk
 *
 */
@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String createUser() {
		Userdb user = new Userdb("Sudhir", "Kumar", "Hyderabad");
		Userdb save = userRepository.save(user);
		return "created";
	}
}
