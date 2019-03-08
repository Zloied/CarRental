package com.vais.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "car_rental.feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
	@SequenceGenerator(name = "feedback_seq", sequenceName = "car_rental.order_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "text_field", length = 128)
	private String textField;

	@Column(name = "rating")
	private int rating;

	@Column(name = "user_name")
	private String userName;

	public Feedback() {
	}

	public Feedback(String textField, int rating, String userName) {
		super();
		this.textField = textField;
		this.rating = rating;
		this.userName = userName;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the textField
	 */
	public String getTextField() {
		return textField;
	}

	/**
	 * @param textField the textField to set
	 */
	public void setTextField(String textField) {
		this.textField = textField;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
