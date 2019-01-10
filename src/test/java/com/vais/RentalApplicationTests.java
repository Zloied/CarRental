package com.vais;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.vais.entities.Car;
import com.vais.models.OrderStat;
import com.vais.models.UserInfo;
import com.vais.repositories.CarRepository;
import com.vais.repositories.OrderRepository;
import com.vais.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalApplicationTests {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CarRepository carRepository;
	@Autowired 
	OrderRepository orderRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	@Transactional
	public void checkOrderStats() {
		//Mapping native query result to POJO model class 
		String sql = "Select id, userId, bill FROM car_rental.orders ";
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")

		Query<OrderStat> query = session.createNativeQuery(sql, "OrderStatMapping");
		List<OrderStat> stats = query.getResultList();
		for (OrderStat orderStat : stats) {
			System.out.println(orderStat.toString());
		}
	}

	@Test
	public void callUserPagination() {

		List<UserInfo> list = userRepository.getPaginatedUInfo(2, 1);
		for (UserInfo userInfo : list) {
			System.out.println(userInfo.toString());
		}
	}

	@Test
	public void checkPriceUpdates() {
		List<Car> list = carRepository.getCars();
		list.forEach(str -> System.out.println(str));
		carRepository.updatePrices(2);
		list = carRepository.getCars();	
		list.forEach(str -> System.out.println(str));

	}
	
	@Test
	public void chechCompareToAvg() {
		orderRepository.getCompToAvg();
	}

}
