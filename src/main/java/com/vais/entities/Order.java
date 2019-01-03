package com.vais.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Eduard. This class is entity for Order from Database. This class has
 *         generated getters and setters for interaction with fields like id ,
 *         starting date, bill etc.
 *
 */

@Entity

@Table(name = "car_rental.orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 2159650216587665394L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_seq")
	@SequenceGenerator(
			name="order_seq",
			sequenceName="car_rental.orders_id_seq",
			allocationSize=10,
			initialValue=7 
			)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "userId")
	private Long userId;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<OrderItem> orderItems;

	@Column(name = "bill")
	private int bill;

	@Column(name = "status")
	private String status;

	@Column(name = "driver")
	private String driver;

	@Column(name = "start_date")
	private Date start_date;

	@Column(name = "end_date")
	private Date finish_date;

	/**
	 * @return id of the order
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id sets id of the order equals id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return UserId who made order
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId who made the order
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * @param orderItem the item that should be added to an order
	 */
	public void addOrderItem(OrderItem orderItem) {
		if (orderItems == null) {
			orderItems = new ArrayList<>();
		}
		this.orderItems.add(orderItem);
	}

	/**
	 * @return bill to pay for order
	 */
	public int getBill() {
		return bill;
	}

	/**
	 * @param bill sets how much user have to pay for order
	 */
	public void setBill(int bill) {
		this.bill = bill;
	}

	/**
	 * @return current status of the order
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status sets current status of the order
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return is including the order a driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @param driver is sets including a driver in order
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @return date when order starts
	 */
	public Date getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date set date when order starts
	 */
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return last_date of the order
	 */
	public Date getFinish_date() {
		return finish_date;
	}

	/**
	 * @param finish_date sets last day of the order
	 */
	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", orderItems=" + orderItems + ", bill=" + bill + ", status="
				+ status + ", driver=" + driver + ", start_date=" + start_date + ", finish_date=" + finish_date + "]";
	}

}
