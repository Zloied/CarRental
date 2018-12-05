package com.vais.repositories;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vais.entities.User;

@Repository
@Transactional
public class UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

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
	
	public User getUser(Long id) {
		User user = null;
		Session session = this.sessionFactory.getCurrentSession();
		user = session.find(User.class, id);
		return user;
	}

	public List<User> getUsers() {
		List<User> userList = null;
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from " + User.class.getName();
		Query<User> query = session.createQuery(sql, User.class);
		userList = query.getResultList();
		// userList = session.createQuery("from " + User.class.getName()).list();

		return userList;
	}

	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateUserStatus(Long id, String status) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		user.setStatus(status);

	}

	public void deleteUser(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.delete(user); 
	}

}
