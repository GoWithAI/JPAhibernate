package test.practice.relationShipTargetEntity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class FullTimeEmployee extends Employee {

	private BigDecimal salary;

	@ManyToOne
	Course course;

	public FullTimeEmployee() {

	}

	public FullTimeEmployee(BigDecimal salary, String name) {
		super(name);
		this.salary = salary;
	}
}
