package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestController {
	
	@Autowired
	DaoService dao;

	@GetMapping("/")
	public String fun1(@RequestParam(value = "name", defaultValue = "abcd") String name) {
		return ("CRUD Operations with " + name);
	}
	
	@PostMapping("/fb")
	public String insertFeedback(@RequestBody Feedback fb) {
		System.out.println("Insert Feedback");
		System.out.println(fb);
		dao.createFeedback(fb);
		return "Inserted - FB";
	}
	
	@PostMapping("/user")
	public String insertUser(@RequestBody User user) {
		System.out.println("Inserting User");
		System.out.println(user);
		dao.createUser(user);
		return "Inserted - USER";
	}
	
	@PostMapping("/check")
	public User checkUser(@RequestBody User user1) {
		System.out.println("Checking User");
		System.out.println(user1);
		User user2 = dao.getUserByName(user1.getName());
		System.out.println(user2);
		if(user2 != null) {
			if(user2.getPassword().equals(user1.getPassword())) {
				user2.setPassword("null");
			}
			else {
				user2 = new User();
				user2.setName("null");
			}
		}
		else {
			user2 = new User();
			user2.setName("null");
		}
		return user2;
	}
	
	@PutMapping("/fb")
	public String updateFeedback(@RequestBody Feedback fb) {
		System.out.println("Update Feedback");
		System.out.println(fb);
		dao.deleteFeedbackByName(fb.getName());
		dao.createFeedback(fb);
		return "Updated  - FB";
	}
	
	@GetMapping("/fb")
	public List<Feedback> getFeedback() {
		System.out.println("Get Feedback");
		Feedback fb = new Feedback();
		fb.setName("Sample");
		fb.setProductQuality(2);
		fb.setProductEfficiency(3);
		fb.setFeedback("ok");
		System.out.println(fb);
		List<Feedback> l = dao.getAllFeedback();
		return l;
	}
	
	@DeleteMapping("/fb")
	public List<Feedback> deleteFeedback(@RequestParam("name") String name) {
		System.out.println("Delete Feedback");
		dao.deleteFeedbackByName(name);
		System.out.println(name + " Deleted");
		return dao.getAllFeedback();
	}
}
