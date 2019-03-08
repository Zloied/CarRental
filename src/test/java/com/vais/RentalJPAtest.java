package com.vais;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vais.entities.User;
import com.vais.repositories.CarRepository;
import com.vais.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalJPAtest {

	@Autowired
	UserRepository userRepository;
	@Autowired
	CarRepository carRepository;

	@Test
	public void addAndDeleteUserTest() throws Exception {
		// Creating an User object and saving into database
		User testUser = new User("Bob", "Find345", "user", "Bob@mail.com", "confirmed");
		userRepository.addUser(testUser);

		// Retrieving and checking User entity
		User retrievedUser = userRepository.getUserByName(testUser.getName());
		assertEquals(testUser.getName(), retrievedUser.getName());
		userRepository.deleteUser(retrievedUser.getId());
		assertEquals(null, userRepository.getUserByName(testUser.getName()));
	}

}
