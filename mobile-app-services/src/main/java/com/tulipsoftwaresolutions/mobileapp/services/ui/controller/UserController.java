package com.tulipsoftwaresolutions.mobileapp.services.ui.controller;

import com.tulipsoftwaresolutions.mobileapp.services.exceptions.UserServiceException;
import com.tulipsoftwaresolutions.mobileapp.services.ui.model.request.UpdateUserDetailsRequestModel;
import com.tulipsoftwaresolutions.mobileapp.services.ui.model.request.UserDetailsRequestModel;
import com.tulipsoftwaresolutions.mobileapp.services.userservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tulipsoftwaresolutions.mobileapp.services.ui.model.response.UserRest;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") // http:localhost:8085/users
public class UserController {

	Map<String, UserRest> users;

	@Autowired
	UserService userService;

	@GetMapping
	public String getUsers() {
		return "get user was called";
	}
}
