package com.drivingschool.drivingschool.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import Exception.InvalidUserException;

@RestController
@RequestMapping("/api/v1/users")
public class UserApi {

	private final UserService userController;

	@Autowired
	public UserApi(UserService userController) {
		this.userController = userController;
	}

	@GetMapping()
	public List<User> getAllUsers() {
		return userController.getAllUsers();
	}

	@PostMapping()
	public void registerNewUser(@RequestBody User newUser) {
		userController.addUser(newUser);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userController.deleteUser(id);
	}

	@PutMapping("/{id}")
	public void updateUser(@PathVariable Long id, @RequestBody User user) throws InvalidUserException {
		userController.updateUser(id, user.getName(), user.getEmail());

	}

}
