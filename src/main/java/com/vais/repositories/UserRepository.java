package com.vais.repositories;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vais.entities.User;
import com.vais.models.UserInfo;

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
			String sql = "Select e from " + User.class.getName() + " e Where e.name =:name and e.password =:password";

			Session session = this.sessionFactory.getCurrentSession();
			Query<User> query = session.createQuery(sql, User.class);
			query.setParameter("name", login);
			query.setParameter("password", password);
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
			String sql = "Select e from " + User.class.getName() + " e Where e.name =:name";

			Session session = this.sessionFactory.getCurrentSession();
			Query<User> query = session.createQuery(sql, User.class);
			query.setParameter("name", login);
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
		String sql = "from " + User.class.getName();
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
		String sql = "SELECT * FROM car_rental.users where users.id = ANY (SELECT orders.userId FROM car_rental.orders "
				+ "GROUP BY orders.userId HAVING COUNT(orders.userId) >?)";
		Query<User> query = session.createNativeQuery(sql, User.class);
		query.setParameter(1, number);
		list = query.getResultList();

		return list;
	}

	/**
	 * Retries short info about users from database.Information consists of user's
	 * id , user's name , user's email.
	 * 
	 * @return List of UserInfo representation class
	 */
	public List<UserInfo> getUsersInfo() {
		List<UserInfo> usersInfo = null;

		String uSql = "Select new " + UserInfo.class.getName() + "(u.id, u.name, u.email) " + " from "
				+ User.class.getName() + " u order by u.id";
		Session session2 = this.sessionFactory.getCurrentSession();
		Query<UserInfo> uQuery = session2.createQuery(uSql, UserInfo.class);
		usersInfo = uQuery.getResultList();

		return usersInfo;
	}

	/**
	 * Retrievs paginated data as entities list of UserInfo representation class .
	 * This method uses JPA Criteria IPA to construct query
	 * 
	 * @param offset
	 * @param begin
	 * @return
	 */
	public List<UserInfo> getPaginatedUInfo(int offset, int begin) {
		List<UserInfo> infoList = null;

		// Building a criteria
		Session session1 = this.sessionFactory.getCurrentSession();
		CriteriaBuilder criteria = session1.getCriteriaBuilder();
		CriteriaQuery<UserInfo> q = criteria.createQuery(UserInfo.class);
		Root<User> root = q.from(User.class);
		q.select(criteria.construct(UserInfo.class, root.get("id"), root.get("name"), root.get("email")));

		// setting up pagination
		TypedQuery<UserInfo> quer = session1.createQuery(q);
		quer.setFirstResult(begin);
		quer.setMaxResults(offset);
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
