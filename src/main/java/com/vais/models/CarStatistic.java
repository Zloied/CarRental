package com.vais.models;

import java.io.Serializable;

/**
 * this is POJO class used to represent certain columns from database such as:
 * id of the car, model of the car, and total amount of times that car have been
 * used
 * 
 * @author Eduard
 *
 */
public class CarStatistic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2664817166340105639L;
	private Long carId;
	private String model;
	private Long useCount;

	public CarStatistic(Long carId, String model, Long useCount) {
		super();
		this.carId = carId;
		this.model = model;
		this.useCount = useCount;
	}

	/**
	 * @return the carId
	 */
	public Long getCarId() {
		return carId;
	}

	/**
	 * @param carId the carId to set
	 */
	public void setCarId(Long carId) {
		this.carId = carId;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the useCount
	 */
	public Long getUseCount() {
		return useCount;
	}

	/**
	 * @param useCount the useCount to set
	 */
	public void setUseCount(Long useCount) {
		this.useCount = useCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarStatistic [carId=" + carId + ", model=" + model + ", useCount=" + useCount + "]";
	}

}
