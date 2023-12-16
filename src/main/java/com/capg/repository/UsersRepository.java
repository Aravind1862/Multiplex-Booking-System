package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{

	Users findByEmailId(String emailId);
	Users findByUserId(int userId);
	 

}
