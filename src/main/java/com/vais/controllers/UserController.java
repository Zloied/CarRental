package com.vais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vais.entities.User;
import com.vais.repositories.UserRepository;

/**
 * this controller reacts to FE requests and manipulate with user entities in
 * database via hibernate
 * 
 * @author Eduard
 *
 */
@Controller
@Transactional
@SessionAttributes({ "userId", "role" })
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logIn(ModelMap model, @RequestParam String login, @RequestParam String pasw) {

		User user = userRepository.validateUser(login, pasw);
		if (user == null) {
			return "redirect:/loginPage";
		}
		model.put("userId", user.getId());
		model.put("role", user.getRole());

		switch (user.getRole()) {
		case "user":
			return "redirect:/userHome";

		case "admin":
			return "redirect:adminHome";

		case "manager":
			return "redirect:managerHome";
		default:
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(ModelMap model, @RequestParam String login, @RequestParam String password1,
			@RequestParam String email) {

		User user = userRepository.getUserByName(login);
		if (user != null) {
			model.put("msg", "such user already exists");
			return "redirect:/registrations";
		}

		userRepository.addUser(new User(login, password1, "user", email, "unconfirmed"));
		User newUser = userRepository.getUserByName(login);
		model.put("userId", newUser.getId());
		model.put("role", newUser.getRole());

		switch (newUser.getRole()) {
		case "user":
			return "redirect:/userHome";

		case "admin":
			return "redirect:/adminHome";

		case "manager":
			return "redirect:/managerHome";
		default:
			return "redirect:/login";

		}

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Model getUsers(Model model, ModelMap modelMap) {

		String role = (String) modelMap.get("role");
		if ("manager".equals(role)) {
			List<User> userList = userRepository.getUsers();
			model.addAttribute("listUsers", userList);
			return model;
		} else {
			return model;
		}
	}

	@RequestMapping(value = "/users/{userId}")
	public String changeStatus(@PathVariable Long userId, @RequestParam String setStatus,
			@RequestParam String command) {

		switch (command) {
		case "Delete":
			userRepository.deleteUser(userId);
			break;
		case "ChangeStatus":
			userRepository.updateUserStatus(userId, setStatus);
			break;
		default:
			break;
		}

		return "redirect:/adminHome";
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String addUser(@RequestParam String login, @RequestParam String email, @RequestParam String password1,
			@RequestParam String setRole, ModelMap modelMap) {

		String role = (String) modelMap.get("role");
		if ("manager".equals(role)) {
			User user = new User();
			user.setName(login);
			user.setEmail(email);
			user.setPassword(password1);
			user.setRole(setRole);
			user.setStatus("confirmed");
			userRepository.addUser(user);

			return "redirect:/adminHome";
		} else {
			return "redirect:/home";
		}
	}

}
