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
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit") int limit, @RequestParam(value = "sort", required = false) String sort) {
		return "get user was called with page = " + page + " and limit = " + limit + " Sorted = " + sort;
	}

	@GetMapping(path = "/{userId}", 
			produces = { 
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE 
					})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		if(users != null && users.containsKey(userId)){
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(
			consumes = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	},
			produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})
	public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel) {
		UserRest user = userService.createUser(userDetailsRequestModel);
		return new ResponseEntity<UserRest>(user, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}",
			consumes = {
				MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE
			},
			produces = {
				MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE
			}
	)
	public ResponseEntity updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {
		if(users.containsKey(userId)){
			UserRest storedUserDetails = users.get(userId);
			storedUserDetails.setFirstName(updateUserDetailsRequestModel.getFirstName());
			storedUserDetails.setLastName(updateUserDetailsRequestModel.getLastName());

			users.put(userId, storedUserDetails);

			return new ResponseEntity<UserRest>(storedUserDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity deleteUser(@PathVariable String userId) {
		if(true) throw new UserServiceException("Thrown by User Service Exception");
		if(users.containsKey(userId)){
			users.remove(userId);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
