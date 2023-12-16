package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.UsersDto;
import com.capg.entity.Users;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.InvalidEmailException;
import com.capg.exception.InvalidGenderException;
import com.capg.exception.InvalidNameException;
import com.capg.exception.InvalidPasswordException;
import com.capg.exception.PasswordMismatchException;

import com.capg.exception.UsersAlreadyExistsException;
import com.capg.repository.UsersRepository;
import com.capg.utility.AppConstant;

@Service
public class UsersServiceImpl implements UsersService 
{
	/*
	 * 
	 * @Description : This method is used to add a product 
	 * @Param : It takes product as a parameter
	 * @returns  : It returns the product
	 * @throws :Tells the developer what exceptions might arise in the code 
	 * @createdDate : 7-12-2023
	 * @author : 
	 */ 
	
	@Autowired
	private UsersRepository userRepo;

	public Users createUser(Users users) {
		Users local = this.userRepo.findByEmailId(users.getEmailId());

		if (local != null) {
			throw new UsersAlreadyExistsException("User already present");
		} else {
			if (!users.getUserName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)?$")) {
				throw new InvalidNameException(AppConstant.INVALID_NAME_INFO);
			}
			if (!users.getEmailId().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
				throw new InvalidEmailException(AppConstant.INVALID_EMAIL_INFO);
			}
			if (!users.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$")) {
				throw new InvalidPasswordException(AppConstant.INVALID_PASSWORD_INFO);
			}

		}
		Users newUser = new Users();
		newUser.setEmailId(users.getEmailId());
		newUser.setUserName(users.getUserName());
		newUser.setMobileNo(users.getMobileNo());
		newUser.setPassword(users.getPassword());
		return userRepo.save(newUser);

	}
	
//	public Users getUser(String email)throws InvalidEmailException
//	{
//		Users user=this.userRepo.findByEmailId(email);
//	
//		if(user==null)
//		{
//			System.out.println("Exception being thrown");
//			throw new InvalidEmailException(AppConstant.USER_INVALID_EMAIL_INFO);
//		}
//		return user;
//	
//	}
//	
	public String deleteUser(int userId)throws IdNotFoundException
	{
		Users user= userRepo.findByUserId(userId);
		if(user == null)
		{
			throw new IdNotFoundException(AppConstant.USER_ID_NOT_FOUND_INFO);
		}
		else {
			userRepo.deleteById(userId);
		}
		return "Id deleted Successfully";
	}
	
	
	
	public String checkUserByEmail(UsersDto user){
		Users check_user = userRepo.findByEmailId(user.getEmailId().toLowerCase());
		if(check_user !=null) {
			if(check_user.getPassword().equals(user.getPassword())) {
				return "Welcome User";
			}else {
				throw new InvalidPasswordException(AppConstant.USERNAME_OR_PASSWORD_MISMATCH);
			}
		}
		throw new InvalidEmailException(AppConstant.USERNAME_OR_PASSWORD_MISMATCH);
	}
	
//	public String forgotUserPassword(UserDto userDto) throws InvalidEmailException,InvalidPasswordException,PasswordMismatchException{
//		Users user = userRepo.findByEmail(userDto.getEmail());
//		if(user == null) {
//			throw new InvalidEmailException(AppConstant.USER_INVALID_EMAIL_INFO);
//		}else if(!userDto.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$") || !userDto.getConfirmPassword().matches("^[a-zA-Z0-9_@#]{8,14}$"))
//			throw new InvalidPasswordException(AppConstant.INVALID_PASSWORD_INFO);
//		else if(!userDto.getPassword().equals(userDto.getConfirmPassword()))
//			throw new PasswordMismatchException(AppConstant.PASSWORD_MISMATCH_INFO);
//		else{
//			user.setPassword(userDto.getPassword());
//			userRepo.save(user);
//			return "Password Reset Successful";
//		}
//	}
//	
//	public String resetUserPassword(int userId,UsersDto userDto) throws IdNotFoundException,InvalidPasswordException,PasswordMismatchException{
//		UsersDto user = userRepos.findByUserId(userId);
//		if (user == null) {
//			throw new IdNotFoundException(AppConstant.USER_ID_NOT_FOUND_INFO);
//		}else if(!userDto.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$") || !userDto.getConfirmPassword().matches("^[a-zA-Z0-9_@#]{8,14}$"))
//			throw new InvalidPasswordException(AppConstant.INVALID_PASSWORD_INFO);
//		else if(!userDto.getPassword().equals(userDto.getConfirmPassword()))
//			throw new PasswordMismatchException(AppConstants.PASSWORD_MISMATCH_INFO);
//		else {
//			user.setPassword(userDto.getPassword());
//			userRepo.save(user);
//			return "Password Reset Successfull";	
//		}
//	}
	
	public UsersDto getUserDashBoard(int userId) throws IdNotFoundException{
		if(userRepo.existsById(userId)) {
			Users user = userRepo.findByUserId(userId);
//			UsersDto newUser = new UsersDto(user.getUserId(),user.getFirstName(),user.getLastName(),user.getGender(),user.getEmail());
			UsersDto newUser = new UsersDto();
			newUser.setUserId(user.getUserId());
			newUser.setUserName(user.getUserName());
			newUser.setEmailId(user.getEmailId());
			newUser.setMobileNo(user.getMobileNo());
			
			return newUser;
		}
		else {
			throw new IdNotFoundException(AppConstant.USER_ID_NOT_FOUND_INFO);
		}
	}
	public Users updateUserById(int userId,Users user) throws IdNotFoundException,InvalidPasswordException,InvalidNameException,InvalidGenderException
	{
		Users updateUser=this.userRepo.findByUserId(userId);
		if(updateUser==null) {
			throw new IdNotFoundException(AppConstant.USER_ID_NOT_FOUND_INFO);
		}
		else {
			if(!user.getUserName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)?$"))
			{
				throw new InvalidNameException(AppConstant.INVALID_NAME_INFO);
			}else {
				updateUser.setUserName((user.getUserName()));;
				
			}
			}
			return userRepo.save(updateUser);
		}				
	

	@Override
	public String deleteUsers(int userId) throws IdNotFoundException {
		Users user= userRepo.findByUserId(userId);
		if(user == null)
		{
			throw new IdNotFoundException(AppConstant.USER_ID_NOT_FOUND_INFO);
		}
		else {
			userRepo.deleteById(userId);
		}
		return "Id deleted Successfully";
	}

	@Override
	public Users updateUserById(int userId, UsersDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}



}