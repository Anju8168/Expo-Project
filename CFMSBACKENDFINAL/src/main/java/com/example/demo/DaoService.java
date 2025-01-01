package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DaoService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	FeedbackRepository repo2;

	public void createUser(User user) {
		repo.save(user);
	}

	public User getUserByName(String name) {
		return repo.findByName(name);
	}
	
	public void createFeedback(Feedback fb) {
		repo2.save(fb);
	}
	
	public List<Feedback> getAllFeedback() {
		return repo2.findAll();
	}
	public void deleteFeedbackByName(String name) {
		repo2.deleteById(name);
	}

}
