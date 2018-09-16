package test.practice.inheritance;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	private BigDecimal hourlyWage;

	public PartTimeEmployee() {

	}

	public PartTimeEmployee(BigDecimal hourlyWage, String name) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

}
