package com.sumit.redis.repo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.sumit.redis.model.UserDetails;

@Repository
public class UserDetailsRepoImpl implements UserDetailsRepo {

	@Autowired
	private RedisTemplate<String, UserDetails> redisTemplate;

	private HashOperations<String, String, UserDetails> hashOperations;

	UserDetailsRepoImpl(RedisTemplate<String, UserDetails> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(UserDetails userDetails) {
		hashOperations.put("USER", userDetails.getId(), userDetails);
	}

	@Override
	public Map<String, UserDetails> getAllUsers() {
		return hashOperations.entries("USER");
	}

	@Override
	public void update(UserDetails userDetails) {
		save(userDetails);

	}

	@Override
	public void delete(String id) {
		hashOperations.delete("USER", id);
	}

	@Override
	public UserDetails findById(String id) {

		return hashOperations.get("USER", id);
	}

}
