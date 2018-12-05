package com.vais.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vais.entities.Car;

@Repository
@Transactional
public class CarRepository {

	@Autowired
	SessionFactory sessionFactory;

	public Car getCar(Long id) {

		Session session = this.sessionFactory.getCurrentSession();
		return session.find(Car.class, id);
	}

	public List<Car> getCars() {
		List<Car> carList = null;

		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from " + Car.class.getName();
		Query<Car> query = session.createQuery(sql, Car.class);
		carList = query.getResultList();

		return carList;
	}

	public void addCar(Car car) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(car);
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateCar(Car car) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Car.class.getName(), car);
	}

	public void deleteCar(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Car car = session.get(Car.class, id);
		session.delete(car);
	}
}
