package com.capg.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.UsersDto;
import com.capg.entity.Users;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.InvalidEmailException;
import com.capg.exception.InvalidGenderException;
import com.capg.exception.InvalidNameException;
import com.capg.exception.InvalidPasswordException;
import com.capg.exception.PasswordMismatchException;

import com.capg.exception.UsersAlreadyExistsException;
import com.capg.service.UsersService;
 
@RestController
@RequestMapping("/api")

public class UsersController {
	@Autowired
	UsersService userService;
	@PostMapping("/register")
	public ResponseEntity<Users> createUser(@RequestBody Users users)
	{
		return new ResponseEntity<Users>(userService.createUser(users),HttpStatus.OK);
	}
	@PostMapping("/login") 
	public ResponseEntity<String> checkUser(@RequestBody UsersDto usersDto)
	{
		return new ResponseEntity<String>(userService.checkUserByEmail(usersDto),HttpStatus.OK);
	}
	
//	@GetMapping("/user/{email}")
//	public ResponseEntity<Users> getUser(@PathVariable("email") String email) throws InvalidEmailException
//	{
//		return new ResponseEntity<Users>(userService.getUsers(email),HttpStatus.OK);
//	}
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId")int userId) throws IdNotFoundException
	{
		return new ResponseEntity<String>(userService.deleteUsers(userId),HttpStatus.OK);
	}
//	@PostMapping("/forgotPassword")
//	public ResponseEntity<String> forgotPassword(@RequestBody UsersDto userDto) throws InvalidEmailException,InvalidPasswordException,PasswordMismatchException{
//		return new ResponseEntity<String>(userService.forgotUserPassword(userDto),HttpStatus.OK);
//	}
//	@PostMapping("/resetPassword/{userId}")
//	public ResponseEntity<String> resetPassword(@PathVariable("userId") int userId,@RequestBody UsersDto userDto) throws IdNotFoundException,InvalidPasswordException,PasswordMismatchException{
//		return new ResponseEntity<String>(userService.resetUserPassword(userId,userDto),HttpStatus.OK);
//	}
	@GetMapping("/user/dashboard/{userId}")
	public ResponseEntity<UsersDto> userDashboard(@PathVariable("userId") int userId) throws IdNotFoundException {
		return new ResponseEntity<UsersDto>(userService.getUserDashBoard(userId),HttpStatus.OK);
	}
	@PutMapping("/user/dashboard/{userId}")
	public ResponseEntity<Users> userDashboard(@PathVariable("userId")int userId,@RequestBody UsersDto userDto)throws IdNotFoundException,InvalidPasswordException,InvalidNameException,InvalidGenderException{
		return new ResponseEntity<Users>(userService.updateUserById(userId,userDto),HttpStatus.OK);
	}
	@GetMapping("/admin/dashboard/{userId}")
	public ResponseEntity<UsersDto> adminDashboard(@PathVariable("userId") int userId) throws IdNotFoundException {
		return new ResponseEntity<UsersDto>(userService.getUserDashBoard(userId),HttpStatus.OK);
	}
}
