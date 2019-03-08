package com.vais.models;

import java.io.Serializable;
import java.util.Date;

public class OrderDaily implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6802253748095427690L;

	private Long summ;
	private Long count;
	private java.sql.Date start_date;

	public OrderDaily(Long summ, Long count, Date start_date) {
		super();
		this.summ = summ;
		this.count = count;
		this.start_date = (java.sql.Date) start_date;
	}

	/**
	 * @return the summ
	 */
	public Long getSumm() {
		return summ;
	}

	/**
	 * @param summ the summ to set
	 */
	public void setSumm(Long summ) {
		this.summ = summ;
	}

	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * @return the start_date
	 */
	public Date getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date the start_date to set
	 */
	public void setStart_date(java.sql.Date start_date) {
		this.start_date = start_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((summ == null) ? 0 : summ.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDaily other = (OrderDaily) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (summ == null) {
			if (other.summ != null)
				return false;
		} else if (!summ.equals(other.summ))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderDaily [summ=" + summ + ", count=" + count + ", start_date=" + start_date + "]";
	}

}
