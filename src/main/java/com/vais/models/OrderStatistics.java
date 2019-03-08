package com.vais.models;

/**
 * this is POJO class used to represent certain columns from database such as : id
 * of the user, name of the user, total amount of money being spend by user.
 * 
 * @author Eduard
 *
 */
public class OrderStatistics {
	private Long userId;
	private String name;
	private Long spend;

	public OrderStatistics(Long userId, String name, Long spend) {
		this.userId = userId;
		this.name = name;
		this.spend = spend;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the spend
	 */
	public Long getSpend() {
		return spend;
	}

	/**
	 * @param spend the spend to set
	 */
	public void setSpend(Long spend) {
		this.spend = spend;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderStatistics [userId=" + userId + ", name=" + name + ", spend=" + spend + "]";
	}

}
