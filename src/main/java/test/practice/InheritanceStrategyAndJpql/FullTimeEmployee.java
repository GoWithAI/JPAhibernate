package test.practice.InheritanceStrategyAndJpql;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

	private BigDecimal salary;

	public FullTimeEmployee() {

	}

	public FullTimeEmployee(BigDecimal salary, String name) {
		super(name);
		this.salary = salary;
	}
}
