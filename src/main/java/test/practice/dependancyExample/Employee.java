package test.practice.dependancyExample;

public class Employee {

	private int id;

	private String name;

	private String salary;

	// inner Bean
	private Address address;

	public Employee() {
		// This Class Has Address Dependency
		address = new Address();
		System.out.println("Employee Object Constructed!");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + "]"
				+ "Object Ref : " + super.toString();
	}

}
