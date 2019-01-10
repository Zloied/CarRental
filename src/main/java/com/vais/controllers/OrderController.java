package com.vais.controllers;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

import com.vais.entities.Order;
import com.vais.repositories.CarRepository;
import com.vais.repositories.OrderRepository;

/**
 * 
 * @author Eduard .This controller is responsible for manipulations with order
 *         entities in database via Hibernate, from front end layer.
 *
 */
@Controller
@Transactional
@SessionAttributes({ "userId", "role" })
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CarRepository carRepository;

	/**
	 * this method adds new order made on FE into database by calling hibernate data
	 * access repository,
	 * 
	 * @param model     spring ModelMap is required to check user access modifier
	 * @param carId     array of selected cars
	 * @param driver    is driver included into the order or not
	 * @param startDate beginning of the order
	 * @param endDate   and of the order
	 * @return appropriate redirect link 
	 */
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public String addOrder(ModelMap model, @RequestParam Long carId[], @RequestParam String driver,
			@RequestParam Date startDate, @RequestParam Date endDate) {

		System.out.println("driver- " + driver + ", startDate -" + startDate + ", endDate- " + endDate + ", cars ");
		List<Long> carsId = new ArrayList<Long>();
		for (Long long1 : carId) {
			carsId.add(long1);
		}

		Order order = new Order();
		order.setDriver(driver);
		order.setStart_date(startDate);
		order.setFinish_date(endDate);
		order.setStatus("requested");
		order.setUserId((Long) model.get("userId"));

		// Getting and checking number of days there should be at least 1 day
		long days = ChronoUnit.DAYS.between(startDate.toLocalDate(), endDate.toLocalDate());
		if (days >= 1) {
			long bill = 0;

			// calculation the price by getting out car entities from database by Id
			for (Long car : carId) {
				bill = bill + (carRepository.getCar(car).getCost()) * days;
			}
			if (driver.equals("yes")) {
				bill = bill + (days * 35);
			}
			order.setBill((int) bill);

			orderRepository.addOrder(order, carsId);
		} else {
			return "redirect:/userNewOrder";
		}

		return "redirect:/userView";
	}

	/**
	 * this method retrieves orders based on user role from data base
	 * 
	 * @param modelMap required to check user access modifier
	 * @param model    spring UI model, used to retrieve data into FE
	 * @return spring Model
	 */
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public Model getOrders(ModelMap modelMap, Model model) {

		String role = (String) modelMap.get("role");
		System.out.println(role);
		if ("user".equals(role)) {
			model.addAttribute("listOrders", orderRepository.getOrdersByUser((Long) modelMap.get("userId")));
			return model;
		} else if ("manager".equals(role)) {
			model.addAttribute("listOrders", orderRepository.getOrders());
			return model;
		} else {
			return model;
		}
	}
	/**
	 * Retrieves specified order
	 * @param model spring UI model, used to retrieve data into FE
	 * @param modelMap  required to check user access modifier
	 * @param orderId path 
	 * @return redirect link
	 */
	@RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
	public String getOrder(Model model, ModelMap modelMap, @PathVariable Long orderId) {

		String role = (String) modelMap.get("role");
		if ("user".equals(role)) {
			model.addAttribute("Order", orderRepository.getOrder(orderId));
			return "userViewOrder";
		} else if ("manager".equals(role)) {
			model.addAttribute("Order", orderRepository.getOrder(orderId));
			return "managerViewOrder";
		} else {
			return "redirect:/home";
		}
	}
	/**
	 * this method update changes of order status. Only manager is allowed to change status
	 * @param modelMap required to check user access modifier
	 * @param orderId path variable which specify order
	 * @param setStatus status that has to be applied 
	 * @return redirect link
	 */
	@RequestMapping(value = "/orders/change/{orderId}")
	public String setOrderStatus(ModelMap modelMap, @PathVariable Long orderId,
			@RequestParam String setStatus) {

		String role = (String) modelMap.get("role");
		if ("manager".equals(role)) {
			orderRepository.updateOrderStatus(orderId, setStatus);
			return "redirect:/managerOrders";
		} else {
			return "redirect:/home";
		}

	}
}
