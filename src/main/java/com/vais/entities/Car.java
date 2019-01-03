package com.vais.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Eduard this class is entity for Car from Database. This class has
 *         generated getters and setters for interaction with fields like id ,
 *         model etc.
 *
 */

@Entity
@Table(name = "car_rental.cars")
public class Car implements Serializable {

	private static final long serialVersionUID = -5175608523574439852L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
	@SequenceGenerator(
			name = "car_seq",
			sequenceName = "car_rental.cars_id_seq",
			allocationSize = 10
			)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "model")
	private String model;

	@Column(name = "mark")
	private String mark;

	@Column(name = "car_Class")
	private String carClass;

	@Column(name = "cost")
	private int cost;

	public Car() {

	}

	public Car(String model, String mark, String carClass, int cost) {
		this.model = model;
		this.mark = mark;
		this.carClass = carClass;
		this.cost = cost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getCarClass() {
		return carClass;
	}

	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", mark=" + mark + ", carClass=" + carClass + ", cost=" + cost
				+ "]";
	}

}
