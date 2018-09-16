package test.practice.singletonAndPrototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/test/practice/singletonAndPrototype/employeeBean.xml");

		Employee employee = (Employee) applicationContext.getBean("e1");
		Employee employee2 = (Employee) applicationContext.getBean("e1");
		System.out.println(employee);
		System.out.println(employee2);
		System.out.println("************");
		Employee employee3 = (Employee) applicationContext.getBean("e2");
		Employee employee4 = (Employee) applicationContext.getBean("e2");
		System.out.println(employee3);
		System.out.println(employee4);
	}
}
