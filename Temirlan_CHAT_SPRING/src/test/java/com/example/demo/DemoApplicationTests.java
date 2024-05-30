//package com.example.demo;
//
//import com.example.demo.dto.UsersDto;
//import com.example.demo.model.Role;
//import com.example.demo.model.User;
//import com.example.demo.repository.ChatRoomRepository;
//import com.example.demo.repository.MessageRepository;
//import com.example.demo.repository.UserRepository;
//import com.example.demo.services.ChatRoomService;
//import com.example.demo.services.MessageService;
//import com.example.demo.services.UserService;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//@SpringBootTest
//@Transactional
//class DemoApplicationTests {
//	@Autowired
//	private UserRepository userRepository;
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private ChatRoomRepository chatRoomRepository;
//	@Autowired
//	private ChatRoomService chatRoomService;
//	@Autowired
//	private MessageRepository messageRepository;
//	@Autowired
//	private MessageService messageService;
//
//	@Test
//	void contextLoads() {}
//
//	@Test
//	void createUser(){
//		String uniqueUsername = "newUser";
//		User newUser = User.builder()
//				.username(uniqueUsername)
//				.password("password")
//				.role(Role.USER)
//				.build();
//		UsersDto savedUser = userService.createUser(newUser);
//		UsersDto findUser = userService.findByUsername(savedUser.getUsername());
//		Assertions.assertNotNull(findUser);
//		Assertions.assertEquals(savedUser.getId(), findUser.getId());
//		Assertions.assertEquals(savedUser.getUsername(), findUser.getUsername());
//		Assertions.assertEquals(savedUser.getPassword(), findUser.getPassword());
//	}
//
//	@Test
//	void getUserId(){
//		String uniqueUsername = "newUserForId";
//		User newUser = User.builder()
//				.username(uniqueUsername)
//				.password("password")
//				.role(Role.USER)
//				.build();
//		UsersDto savedUser = userService.createUser(newUser);
//		UsersDto findUser = userService.getUserById(savedUser.getId());
//		Assertions.assertNotNull(findUser);
//		Assertions.assertEquals(savedUser.getId(), findUser.getId());
//	}
//}
