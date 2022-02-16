package com.sumit.redis.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.redis.model.UserDetails;
import com.sumit.redis.repo.UserDetailsRepo;

@RestController
@RequestMapping("/api")
public class UserDetailsController {

	private UserDetailsRepo detailsRepo;

	public UserDetailsController(UserDetailsRepo detailsRepo) {
		this.detailsRepo = detailsRepo;
	}

	@GetMapping("/users")
	public Map<String, UserDetails> findAll() {
		return detailsRepo.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public UserDetails findById(String id) {
		return detailsRepo.findById(id);
	}

	@PostMapping("/user")
	public void save(@RequestBody UserDetails userDetails) {
		detailsRepo.save(userDetails);
	}

	@PutMapping("/user")
	public void update(@RequestBody UserDetails userDetails) {
		detailsRepo.update(userDetails);
	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable String id) {
		detailsRepo.delete(id);
	}

}
