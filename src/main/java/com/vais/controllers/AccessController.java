package com.vais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vais.entities.Car;
import com.vais.entities.Order;
import com.vais.entities.User;
import com.vais.models.CarStatistic;
import com.vais.models.OrderDaily;
import com.vais.repositories.CarRepository;
import com.vais.repositories.OrderRepository;
import com.vais.repositories.UserRepository;

/**
 * this controller responsible for access to pages
 */
@Controller
@Transactional
@SessionAttributes({ "userId", "role" })
public class AccessController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CarRepository carRepository;

	@RequestMapping(value = { "/home", "/" })
	public String showHomePage(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = "/login")
	public String goSignIn() {
		// orderRepository.getUsersByOrderCount();
		return "loginPage";
	}

	@RequestMapping(value = "/logOut")
	public String logOut(ModelMap model) {

		model.remove("userId");
		model.remove("role");
		return "redirect:/home";
	}

	@RequestMapping(value = "/registration")
	public String goSignUp() {
		return "registration";
	}

	@RequestMapping(value = "/contacts")
	public String goContacts() {
		return "contacts";
	}

	@RequestMapping(value = "/about")
	public String goAbout() {
		return "about";
	}

	@RequestMapping(value = "/adminHome")
	public String adminAccess(ModelMap model) {

		String role = (String) model.get("role");
		if ("admin".equals(role)) {
			List<User> userList = userRepository.getUsers();
			model.addAttribute("listUsers", userList);
			return "adminHome";
		} else {
			return "redirect:/home";
		}

	}

	@RequestMapping(value = "/adminAdd")
	public String goAdminAdd(ModelMap model) {

		String role = (String) model.get("role");
		if ("admin".equals(role)) {
			return "adminAdd";
		} else {
			return "redirect:/home";
		}
	}

	@RequestMapping(value = "/managerHome")
	public String goManagerHome(ModelMap modelMap) {

		String role = (String) modelMap.get("role");
		if ("manager".equals(role)) {
			return "managerHome";
		} else {
			return "redirect:/home";
		}
	}

	@RequestMapping(value = "/manager/statistics")
	public String goManagerStatistics(Model model) {

		model.addAttribute("CARS_STAT", carRepository.getCarsStatistic());
		return "managerStatistics";
	}

	@RequestMapping(value = "/managerCars")
	public String goManagerCars(Model model, ModelMap modelMap) {

		String role = (String) modelMap.get("role");
		if ("manager".equals(role)) {
			List<Car> cars = carRepository.getCars();
			model.addAttribute("CARS_LIST", cars);
			return "managerCars";
		} else {
			return "redirect:/home";
		}
	}

	@RequestMapping(value = "/managerCarsStat")
	public String goManagerCarsStatistic(Model model, ModelMap modelMap) {

		String role = (String) modelMap.get("role");
		if ("manager".equals(role)) {
			List<CarStatistic> carsStat = carRepository.getCarsStatistic();
			model.addAttribute("CARS_STAT", carsStat);
			return "managerCarsStat";
		} else {
			return "redirect:/home";
		}

	}

	@RequestMapping(value = "/managerCarChange")
	public String goManagerCarChange(ModelMap modelMap) {

		String role = (String) modelMap.get("role");
		if ("manager".equals(role)) {
			return "managerCarChange";
		} else {
			return "redirect:/home";
		}
	}

	@RequestMapping(value = "/managerOrders")
	public String goManagerOrders(ModelMap modelMap, Model model) {

		String role = (String) modelMap.get("role");
		if ("manager".equals(role)) {
			List<Order> orders = orderRepository.getOrders();
			model.addAttribute("listOrders", orders);
			return "managerOrders";
		} else {
			return "redirect:/home";
		}

	}

	@RequestMapping(value = "/managerReports")
	public String goManagerReports(ModelMap modelMap, Model model) {

		String role = (String) modelMap.get("role");
		if ("manager".equals(role)) {
			List<OrderDaily> orders = orderRepository.getOrderReports();
			model.addAttribute("listOrderReports", orders);
			return "managerOrdersReports";
		} else {
			return "redirect:/home";
		}
	}

	@RequestMapping(value = "/userView")
	public String userViewOrders(ModelMap modelMap, Model model) {
		String role = (String) modelMap.get("role");

		if ("user".equals(role)) {
			Long userId = (Long) modelMap.get("userId");
			List<Order> orders = orderRepository.getOrdersByUser(userId);
			model.addAttribute("listOrders", orders);
			return "userView";
		} else {
			return "redirect:/home";
		}

	}

	@RequestMapping(value = "/userHome")
	public String userHome(ModelMap model) {

		String role = (String) model.get("role");
		if ("user".equals(role)) {
			return "userHome";
		} else {
			return "redirect:/home";
		}
	}

	@RequestMapping(value = "/userFeedback")
	public String userFeedback(ModelMap model) {

		String role = (String) model.get("role");
		if ("user".equals(role)) {
			return "userFeedback";
		} else {
			return "redirect:/home";
		}
	}

	@RequestMapping(value = "/userNewOrder")
	public String userMakeNewOrder(ModelMap modelMap, Model model) {

		String role = (String) modelMap.get("role");
		if ("user".equals(role)) {

			List<Car> cars = carRepository.getCars();
			model.addAttribute("CARS_LIST", cars);
			return "userNewOrder";
		} else {
			return "redirect:/home";
		}

	}
}
