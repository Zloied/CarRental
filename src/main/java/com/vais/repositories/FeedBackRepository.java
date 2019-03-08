package com.vais.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vais.entities.Feedback;

@Repository
@Transactional
public class FeedBackRepository {
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * adds new feedback entity from incoming parameter into the database .
	 * 
	 * @param feedback new entity that has to be saves
	 */
	public void addFeedback(Feedback feedback) {
		Session session = this.sessionFactory.getCurrentSession();
		if (feedback != null) {
			session.persist(feedback);
		}
	}

	/**
	 * retrieves feedback entity of certain user from database.
	 * 
	 * @param userName name of the user
	 * @return feedback entity
	 */
	public Feedback getFeedback(String userName) {

		String sql = "From " + Feedback.class.getName() + " WHERE userName=:userName";
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Feedback> query = session.createQuery(sql, Feedback.class);
		query.setParameter("userName", userName);
		return query.getSingleResult();
	}

	/**
	 * retrieves all feedback entities from the database
	 * 
	 * @return List of feedback entities
	 */
	public List<Feedback> getFeedbacks() {
		List<Feedback> list = null;

		String sql = "FROM " + Feedback.class.getName();
		Session session = this.sessionFactory.getCurrentSession();
		list = session.createQuery(sql, Feedback.class).getResultList();
		return list;
	}
}
