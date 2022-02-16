package com.sumit.redis.repo;

import java.util.Map;

import com.sumit.redis.model.UserDetails;

public interface UserDetailsRepo {

	void save(UserDetails userDetails);

	Map<String, UserDetails> getAllUsers();

	void update(UserDetails userDetails);

	void delete(String id);
	
	UserDetails findById(String id);

}
