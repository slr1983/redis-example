package com.sumit.redis.model;

import java.io.Serializable;
import java.util.Objects;

public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4207471365925148654L;
	private String id;
	private String name;

	@Override
	public int hashCode() {
		return Objects.hash(id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(salary, other.salary);
	}

	public UserDetails(String id, String name, Long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	private Long salary;

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
