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

import com.vais.models.OrderInfo;
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
	public void checkOrderInfos() {
		// Mapping native query result to POJO model class
		String sql = "Select id, userId, bill FROM car_rental.orders ";
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")

		Query<OrderInfo> query = session.createNativeQuery(sql, "OrderInfoMapping");
		List<OrderInfo> stats = query.getResultList();
		stats.forEach(st -> System.out.println(st));
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
		carRepository.getCars().forEach(s -> System.out.println(s));
		carRepository.updatePrices(2);
		carRepository.getCars().forEach(s -> System.out.println(s));

	}

	@Test
	public void chechCompareToAvg() {
		orderRepository.getCompToAvg();

	}

	@Test
	public void chechOrderReports() {
		orderRepository.getOrderReports().forEach(o -> System.out.println(o.toString()));
	}

}
