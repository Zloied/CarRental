package com.vais.controllers;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
public class UserController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * adds new user with such as incoming parameters into the database, but only in
	 * case if user doesn't already exist.
	 * 
	 * @param model     Spring ModelMap class used to put and get parameters from
	 *                  session
	 * @param login     received from request
	 * @param password1 user's password received from request
	 * @param email     user's email received from request
	 * @return redirection to appropriate page
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(HttpServletRequest request, ModelMap model, @RequestParam(required = false) String login,
			@RequestParam(required = false) String password1, @RequestParam String email) {

		if (login != null && password1 != null) {
			User user = userRepository.getUserByName(login);
			if (user != null) {
				model.put("msg", "such user already exists");
				return "redirect:/registrations";
			}
			// adding new user into database and calling auto authentication method
			userRepository.addUser(new User(login, password1, "user", email, "unconfirmed"));
			authWithHttpServletRequest(request, login, password1);

			return "redirect:/userHome";
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * reponses to request by retrieving from database and putting user entities
	 * into response
	 * 
	 * @param model    used to put data into response
	 * @param modelMap Spring ModelMap class used to put and get parameters from
	 *                 session
	 * @return Spring model class with data
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Model getUsers(Model model, ModelMap modelMap) {

		List<User> userList = userRepository.getUsers();
		model.addAttribute("listUsers", userList);
		return model;
	}

	/**
	 * process request for updating or deleting an entity from the database.
	 * Extracts parameters from request such as type of command to be applied and
	 * status if there is some.
	 * 
	 * @param userId    identifier of entity to work with
	 * @param setStatus status of the entity
	 * @param command   type of command that has to be applied
	 * @return appropriate redirect link
	 */
	@RequestMapping(value = "/users/{userId}")
	public String changeStatus(@PathVariable Long userId, @RequestParam(required = false) String setStatus,
			@RequestParam String command) {
		if (setStatus != null) {
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
		}
		return "redirect:/adminHome";
	}

	/**
	 * process request for adding new entity to the database. Extracts all required
	 * parameters from request.
	 * 
	 * @param login     user's name
	 * @param email     user's email
	 * @param password1 user's password
	 * @param setRole   user's role
	 * @param modelMap  spring ModelMap class used to extract data from the session
	 * @return appropriate redirect link
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String addUser(@RequestParam String login, @RequestParam(required = true) String email,
			@RequestParam(required = true) String password1, @RequestParam String setRole, ModelMap modelMap) {

		User user = new User();
		user.setName(login);
		user.setEmail(email);
		user.setPassword(password1);
		user.setRole(setRole);
		user.setStatus("confirmed");
		userRepository.addUser(user);

		return "redirect:/adminHome";
	}

	/**
	 * This method is used for auto authentication after successful registration
	 * process
	 * 
	 * @param request  incoming request
	 * @param username user's name
	 * @param password user's password
	 */
	public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
		try {
			request.login(username, password);
		} catch (ServletException e) {
			System.out.println("Wasn't able to autologin successfully " + e);
		}
	}
}
