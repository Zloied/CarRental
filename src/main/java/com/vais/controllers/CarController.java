package com.vais.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vais.entities.Car;
import com.vais.repositories.CarRepository;
import com.vais.utils.UserDetail;

/**
 * 
 * @author Eduard , this controller is responsible for manipulations with car
 *         entity in database via Hibernate, from front end layer.
 *
 */
@Controller
@Transactional
@SessionAttributes("role")
public class CarController {

	@Autowired
	private CarRepository carRepository;

	/**
	 * on request connects to database and pulls out list of cars . Retrieved data
	 * is exposed via spring model
	 * 
	 * @param model    spring Model that used to input parameters for client
	 *                 response
	 * @param modelMap required to check user access modifier
	 * @return spring UI model with List of cars in it
	 */
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public Model getCars(Model model, ModelMap modelMap) {

		model.addAttribute("CARS_LIST", carRepository.getCars());
		return model;
	}

	/**
	 * on request connects to database and pulls out specified(by path variable) car
	 * entity . Retrieved data is exposed via spring model
	 * 
	 * @param modelMap required to check user access modifier
	 * @param model    UI model from spring
	 * @param carId    path variable that indicates which car should be retrieved
	 *                 from database
	 * @return redirect link
	 */
	@RequestMapping(value = "/cars/{carId}", method = RequestMethod.GET)
	public String getCar(Principal principal, Model model, @PathVariable Long carId) {

		UserDetail loginedUser = (UserDetail) ((Authentication) principal).getPrincipal();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) loginedUser.getAuthorities();
		String role = authorities.get(0).getAuthority();
		model.addAttribute("theCar", carRepository.getCar(carId));
		if ("ROLE_USER".equals(role)) {
			return "redirect:/userViewCar";
		} else if ("ROLE_MANAGER".equals(role)) {
			return "redirect:/managerCarChange";
		} else {
			return "redirect:/home";
		}

	}

	/**
	 * this method updates car in database . Update is made based on request
	 * parameters
	 * 
	 * @param model    of car entity
	 * @param mark     of car entity
	 * @param carClass of car entity
	 * @param carCost  of car entity
	 * @param carId    of car entity
	 * @param modelMap required to check user access modifier
	 * @return redirect link
	 */
	@RequestMapping(value = "/cars/{carId}", method = RequestMethod.POST)
	public String changeCar(@RequestParam String model, @RequestParam(required = false) String mark,
			@RequestParam(required = false) String carClass,
			@RequestParam(defaultValue = "0", required = false) int carCost, @PathVariable Long carId) {

		if ((mark != null) && (carClass != null) && (carCost != 0)) {
			Car car = new Car(model, mark, carClass, carCost);
			car.setId(carId);
			carRepository.updateCar(car);
		}
		return "redirect:/managerCars";
	}

	/**
	 * adds new car into database by calling method from hibernate data access
	 * repository and using parameters received from request
	 * 
	 * @param carName  model of car entity received from request
	 * @param mark     of car entity received from request
	 * @param carClass of car entity received from request
	 * @param carCost  of car entity received from request
	 * @param modelMap spring ModelMap class
	 * @return redirect link to managerCars page or to home page if role doesn't
	 *         match "manager"
	 */
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	public String addCar(@RequestParam(required = false) String carName, @RequestParam(required = false) String mark,
			@RequestParam(required = false) String carClass,
			@RequestParam(defaultValue = "0", required = false) int carCost, ModelMap modelMap) {

		if ((carName != null) && (mark != null) && (carClass != null) && (carCost != 0)) {
			Car car = new Car(carName, mark, carClass, carCost);
			carRepository.addCar(car);
		}
		return "redirect:/managerCars";
	}

	/**
	 * deletes defined car , access to delete a car has only manager
	 * 
	 * @param carId    of car entity received from request
	 * @param modelMap spring ModelMap class
	 * @return redirect link to managerCars page or to home page if role doesn't
	 *         match "manager"
	 */
	@RequestMapping(value = "/cars/delete/{carId}")
	public String deleteCar(@PathVariable Long carId, ModelMap modelMap) {

		carRepository.deleteCar(carId);
		return "redirect:/managerCars";
	}
}
