package test.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class AppllicationTest {

	public static void main(String[] args) {

		// General Way
		/*Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Deepak");
		employee.setSalary("1000");*/

		// System.out.println("Ex details"+employee);

		// Spring Way
		// Insersion of Controle
		// 1.BeanFactory

		//1. Bean Factory | Spring IOC constructs the object when Request only 
		Resource resource = new ClassPathResource("/test/practice/employeeBean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		//Employee employee2 = (Employee) factory.getBean("e1");//after Request Object is getting created 
		//Employee employee3 = factory.getBean("e2", Employee.class);
		
		//System.out.println("emp1 :" + employee2);
		//System.out.println("emp2 :" + employee3);
		
		//2.ApplicationContext | Spring IOC Container | It construct object even when we do not request
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("/test/practice/employeeBean.xml");
		
		//Employee employee4=(Employee)applicationContext.getBean("e1");//Object is already Created 
		//Employee employee5=applicationContext.getBean("e2",Employee.class);

	}

}
