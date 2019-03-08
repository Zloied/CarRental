package com.vais.models;

/**
 * this is POJO class used to represent certain columns from database such as:
 * order's id, user's name, order's bill
 * 
 * @author Eduard
 *
 */
public class OrderUsersDetail {
	private Long id;
	private String userName;
	private int bill;

	public OrderUsersDetail(Long id, String userName, int bill) {
		this.id = id;
		this.userName = userName;
		this.bill = bill;
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

	/**
	 * @return the bill
	 */
	public int getBill() {
		return bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(int bill) {
		this.bill = bill;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderUsersDetail [id=" + id + ", userName=" + userName + ", bill=" + bill + "]";
	}

}
