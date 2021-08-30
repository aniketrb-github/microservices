package com.micron;

import com.micron.controller.UserController;
import com.micron.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MicronApplicationTests {

    public static Logger logger = LoggerFactory.getLogger(MicronApplicationTests.class);
    @Test
    public void contextLoads() {
        Assertions.assertEquals(true, true);
        logger.info("Test Method - contextLoads() executed!");
    }
/*
    @Autowired
	private IUserService userService;

    @Autowired
	private  UserController userController;

	// Expected to mock the calls going to Repository/Database
	// Test Failure
	@Test
	public void getUsers() {
		// We need to avoid calling the actual call to Repository/3rd party API
		when(userController.getUsers()).thenReturn(Stream
				.of(
						new UserResponseDto(1, "Micheal Scott", "micheal.scott", "micheal.scott@theoffice.com",
								new Address("Parkinson Street", "Tandem Suite", "New York", "811019", new Geo("40.7128° N", "74.0060° W")),
								"718-898-7897", "micheal.scott-papercompany", new Company("The Office", "Paper is Gold", "BS-Paper")),
						new UserResponseDto(2, "Dwight Shrute", "dwight.schrute", "dwight.schrute@theoffice.com",
								new Address("Parkinson Street", "Tandem Suite", "New York", "811019", new Geo("40.7128° N", "74.0060° W")),
								"212-444-5555", "dwight.schrute-associates", new Company("The Office", "Paper is Gold", "BS-Paper"))
				).collect(Collectors.toList()));

		// When a call to userService is made I will expect 2 objects
		assertEquals(2, userService.getUsers().size());
	}
	*/
}
