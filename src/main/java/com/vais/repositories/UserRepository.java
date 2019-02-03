package com.vais.repositories;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vais.entities.Order;
import com.vais.entities.User;
import com.vais.models.UserInfo;
import com.vais.models.User_;

@Repository
@Transactional
public class UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * checks if user's with such login and password as incoming parameters exists
	 * in database
	 * 
	 * @param login    user's login to check
	 * @param password user's password to check
	 * @return User entity
	 */
	public User validateUser(String login, String password) {
		User user = null;

		try {
			String sql = "SELECT e FROM " + User.class.getName() + " e WHERE e.name =:name AND e.password =:password";

			Session session = this.sessionFactory.getCurrentSession();
			Query<User> query = session.createQuery(sql, User.class);
			query.setParameter(User.ATTRIBUTE_NAME, login);
			query.setParameter(User.ATTRIBUTE_PASSWORD, password);
			user = (User) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}

		return user;
	}

	/**
	 * retrieves user entity from database that matches incoming parameter login if
	 * such exists. Otherwise returns null;
	 * 
	 * @param login user's login to check
	 * @return User entity
	 */
	public User getUserByName(String login) {
		try {
			String sql = "SELECT e FROM " + User.class.getName() + " e WHERE e.name=:" + User.ATTRIBUTE_NAME;

			Session session = this.sessionFactory.getCurrentSession();
			Query<User> query = session.createQuery(sql, User.class);
			query.setParameter(User.ATTRIBUTE_NAME, login);
			return (User) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * retrieves user from database where id matches incoming parameter.
	 * 
	 * @param id user's id to check
	 * @return User entity
	 */
	public User getUser(Long id) {
		User user = null;
		Session session = this.sessionFactory.getCurrentSession();
		user = session.find(User.class, id);
		return user;
	}

	/**
	 * pulls out all user entities from database
	 * 
	 * @return List of User entities
	 */
	public List<User> getUsers() {
		List<User> userList = null;

		Session session = this.sessionFactory.getCurrentSession();
		String sql = "FROM " + User.class.getName();
		Query<User> query = session.createQuery(sql, User.class);
		userList = query.getResultList();

		return userList;
	}

	/**
	 * Retrieves user from database that has made certain number of orders
	 * 
	 * @param number of made orders to filter out
	 * @return List of User entities
	 */
	public List<User> getUsersByOrderN(int number) {
		List<User> list = null;

		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT * FROM car_rental.users WHERE users.id = ANY (SELECT orders.userId FROM car_rental.orders "
				+ "GROUP BY orders.userId HAVING COUNT(orders.userId) >?)";
		Query<User> query = session.createNativeQuery(sql, User.class);
		query.setParameter(1, number);
		list = query.getResultList();

		return list;
	}

	/**
	 * retrieves users from database sorted out by : how many orders was made up by
	 * each user. This method uses Criteria API .
	 * 
	 * @param countNumber minimal number of orders made up by user
	 * @return List of user entities
	 */
	public List<User> getUsersByOrderCount(Long countNumber) {
		// creating the outer query
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);

		// orders made up by user
		Subquery<Long> sub = cq.subquery(Long.class);
		Root<Order> subRoot = sub.from(Order.class);
		sub.select(cb.count(subRoot.get(Order.ATTRIBUTE_ID)));
		sub.groupBy(subRoot.get(Order.ATTRIBUTE_USER_ID));
		sub.where(cb.equal(root.get(User.ATTRIBUTE_ID), subRoot.get(Order.ATTRIBUTE_USER_ID)));

		// check the result of the subquery
		cq.where(cb.greaterThanOrEqualTo(sub, countNumber));
		TypedQuery<User> query = session.createQuery(cq);
		List<User> list = query.getResultList();

		return list;
	}

	/**
	 * Retrieves short info about users from database.Information consists of user's
	 * id , user's name , user's email.
	 * 
	 * @return List of UserInfo representation class
	 */
	public List<UserInfo> getUsersInfo() {
		List<UserInfo> usersInfo = null;

		String Sql = "SELECT new " + UserInfo.class.getName() + "(u.id, u.name, u.email) " + " FROM "
				+ User.class.getName() + " u ORDER BY u.id";
		Session session = this.sessionFactory.getCurrentSession();
		Query<UserInfo> uQuery = session.createQuery(Sql, UserInfo.class);
		usersInfo = uQuery.getResultList();

		return usersInfo;
	}

	/**
	 * Retrieves paginated data as entities list of UserInfo representation class .
	 * This method uses JPA Criteria IPA to construct query
	 * 
	 * @param max   number of record for one page
	 * @param begin starting point in the database
	 * @return list of entities of UserInfo POJO representation class
	 */
	public List<UserInfo> getPaginatedUInfo(int max, int begin) {
		List<UserInfo> infoList = null;

		// Building a criteria
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder criteria = session.getCriteriaBuilder();
		CriteriaQuery<UserInfo> q = criteria.createQuery(UserInfo.class);
		Root<User> root = q.from(User.class);
		q.select(criteria.construct(UserInfo.class, root.get(User_.ID), root.get(User_.NAME), root.get(User_.EMAIL)));

		// setting up pagination
		TypedQuery<UserInfo> quer = session.createQuery(q);
		quer.setFirstResult(begin);
		quer.setMaxResults(max);
		infoList = quer.getResultList();

		return infoList;
	}

	/**
	 * adds new user entity into the database
	 * 
	 * @param user to add
	 */
	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
	}

	/**
	 * updates status of certain user in the database
	 * 
	 * @param id     user's identifier
	 * @param status to change
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateUserStatus(Long id, String status) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		user.setStatus(status);

	}

	/**
	 * deletes user that matches incoming id from the database
	 * 
	 * @param id user's identifier
	 */
	public void deleteUser(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.delete(user);
	}

}
