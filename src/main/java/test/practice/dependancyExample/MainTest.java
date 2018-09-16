package test.practice.dependancyExample;

public class MainTest {

 public static void main(String[] args) {
	Employee employee=new Employee();
	employee.setId(11);
	employee.setName("Deepak");
	employee.setSalary("150000");
	
	Address address=new Address();
	address.setId(1);
	address.setAddress("Pune");

	//This Emlpoyee Object has Dependancy of Address 
	employee.setAddress(address);
	
	System.out.println(employee);
	
	
}
}
