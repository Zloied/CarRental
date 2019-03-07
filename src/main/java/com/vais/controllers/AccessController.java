package com.vais.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import com.vais.utils.UserDetail;

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

	@RequestMapping(value = "/403")
	public String acessDenied() {
		return "accessDenied";
	}

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

		List<User> userList = userRepository.getUsers();
		model.addAttribute("listUsers", userList);
		return "adminHome";
	}

	@RequestMapping(value = "/adminAdd")
	public String goAdminAdd(ModelMap model) {

		return "adminAdd";
	}

	@RequestMapping(value = "/managerHome")
	public String goManagerHome(ModelMap modelMap) {

		return "managerHome";
	}

	@RequestMapping(value = "/manager/statistics")
	public String goManagerStatistics(Model model) {

		model.addAttribute("CARS_STAT", carRepository.getCarsStatistic());
		return "managerStatistics";
	}

	@RequestMapping(value = "/managerCars")
	public String goManagerCars(Model model, ModelMap modelMap) {

		List<Car> cars = carRepository.getCars();
		model.addAttribute("CARS_LIST", cars);
		return "managerCars";
	}

	@RequestMapping(value = "/managerCarsStat")
	public String goManagerCarsStatistic(Model model, ModelMap modelMap) {

		List<CarStatistic> carsStat = carRepository.getCarsStatistic();
		model.addAttribute("CARS_STAT", carsStat);
		return "managerCarsStat";
	}

	@RequestMapping(value = "/managerCarChange")
	public String goManagerCarChange(ModelMap modelMap) {

		return "managerCarChange";
	}

	@RequestMapping(value = "/managerOrders")
	public String goManagerOrders(ModelMap modelMap, Model model) {

		List<Order> orders = orderRepository.getOrders();
		model.addAttribute("listOrders", orders);
		return "managerOrders";
	}

	@RequestMapping(value = "/managerReports")
	public String goManagerReports(ModelMap modelMap, Model model) {

		List<OrderDaily> orders = orderRepository.getOrderReports();
		model.addAttribute("listOrderReports", orders);
		return "managerOrdersReports";
	}

	@RequestMapping(value = "/userView")
	public String userViewOrders(Model model, Principal principal) {

		UserDetail loginedUser = (UserDetail) ((Authentication) principal).getPrincipal();
		List<Order> orders = orderRepository.getOrdersByUser(loginedUser.getUserId());
		model.addAttribute("listOrders", orders);
		return "userView";
	}

	@RequestMapping(value = "/userHome")
	public String userHome(ModelMap model, Principal principal) {
		return "userHome";
	}

	@RequestMapping(value = "/userFeedback")
	public String userFeedback(ModelMap model) {
		return "userFeedback";
	}

	@RequestMapping(value = "/userNewOrder")
	public String userMakeNewOrder(ModelMap modelMap, Model model) {

		List<Car> cars = carRepository.getCars();
		model.addAttribute("CARS_LIST", cars);
		return "userNewOrder";
	}
}
