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
import com.vais.entities.OrderItem;
import com.vais.models.CarStatistic;

@Repository
@Transactional
public class CarRepository {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * this method retrieves certain car from database. Car is chosen by incoming id
	 * 
	 * @param id chosen's car id
	 * @return Car entity
	 */
	public Car getCar(Long id) {

		Session session = this.sessionFactory.getCurrentSession();
		return session.find(Car.class, id);
	}

	/**
	 * this method retrieves all cars from database
	 * 
	 * @return List of Car entities
	 */
	public List<Car> getCars() {
		List<Car> carList = null;

		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from " + Car.class.getName();
		Query<Car> query = session.createQuery(sql, Car.class);
		carList = query.getResultList();

		return carList;
	}

	/**
	 * this method retrieves statistic of how many times each car was ordered
	 * 
	 * @return list of CarStatistic POJO representation entities
	 */
	public List<CarStatistic> getCarsStatistic() {
		List<CarStatistic> carsStat = null;

		String sql = "Select new " + CarStatistic.class.getName() + " (a.id, a.model, COUNT(b.carId)) FROM "
				+ Car.class.getName() + " a INNER JOIN " + OrderItem.class.getName() + " b ON a.id=b.carId "
				+ " GROUP BY a.id " + " ORDER BY COUNT(b.carId) DESC";
		Session session = this.sessionFactory.getCurrentSession();
		Query<CarStatistic> query = session.createQuery(sql, CarStatistic.class);
		carsStat = query.getResultList();

		return carsStat;

	}

	/**
	 * this method pulls out data about cars (car's id , car's model, how many times
	 * car was used) as POJO representation class CarStatistic. This information is
	 * sorted out by min required number of use(incoming parameter).
	 * 
	 * @param number criteria to filter
	 * @return List of CarStatistic POJO classes
	 */
	public List<CarStatistic> getCarUsedN(Long number) {
		List<CarStatistic> carsStatList = null;

		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT new " + CarStatistic.class.getName() + " (a.id, a.model, COUNT(b.carId)) from "
				+ Car.class.getName() + " a inner join " + OrderItem.class.getName() + " b ON a.id = b.carId "
				+ " GROUP BY a.id " + " HAVING COUNT(b.carId)> :number";
		Query<CarStatistic> query = session.createQuery(sql, CarStatistic.class);
		query.setParameter("number", number);
		carsStatList = query.getResultList();

		return carsStatList;
	}

	/**
	 * insert new car into the database
	 * 
	 * @param car entity that has to be added
	 */
	public void addCar(Car car) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(car);
	}

	/**
	 * updates information about existing entity in database
	 * 
	 * @param car entity that has to be updated
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateCar(Car car) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Car.class.getName(), car);
	}

	public void updatePrices(double coef) {
		Session session = this.sessionFactory.getCurrentSession();

		session.flush();
		//String sql = "UPDATE car_rental.cars SET price=price*" + coef + ";";
		String sql = "UPDATE "+Car.class.getName()+" SET cost=cost*" + coef ;
		session.createQuery(sql).executeUpdate();


	}

	/**
	 * deletes car from database by incoming id
	 * 
	 * @param id of car that has to be deleted
	 */
	public void deleteCar(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Car car = session.get(Car.class, id);
		session.delete(car);
	}
}
