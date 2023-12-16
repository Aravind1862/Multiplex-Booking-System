package com.capg.service;

import java.util.List;

import com.capg.dto.UsersDto;
import com.capg.entity.Users;

public interface UsersService {

	//Users addUsers(Users users);
	//List<Users> getAllUsers();
//	String deleteUsersById(int id);
	UsersDto getUserDashBoard(int userId);
	Users updateUserById(int userId, UsersDto userDto);
	//Users getUsers(String email);
	String checkUserByEmail(UsersDto user);
	Users createUser(Users users);
	//String deleteUsers(int userId);
//	String forgotUserPassword(UsersDto userDto);
//	String resetUserPassword(int userId, UsersDto userDto);
	String deleteUsers(int userId);
	
	
}
