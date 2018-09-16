package test.practice.InheritanceStrategyAndJpql;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import ch.qos.logback.core.CoreConstants;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// courseRepository.addReviewForCoruse();
		/*
		 * List<Review> reviews=new ArrayList<>();
		 * 
		 * reviews.add(new Review("7","Cool")); reviews.add(new Review("007","Cool"));
		 * 
		 * courseRepository.addReviewForCourseGeneralized(30001L, reviews);
		 */

		// studentRepository.insertHardcodedStudentAndCourse();
		// studentRepository.insertStudentAndCourse(new Student("Durga"), new
		// Course("Hibernate"));
		// studentRepository.insertStudentInCourse(new Student("DEEPAK"), 20001L);
		// studentRepository.insertCourseInStudent(20002L, new Course("MVC"));

		//employeeRepository.insert(new FullTimeEmployee(new BigDecimal(60000), "Deepak"));
		//employeeRepository.insert(new PartTimeEmployee(new BigDecimal(20), "Durga"));

		//log.info("Fulltime Employees ->{}", employeeRepository.fullTimeRetrive());
		//log.info("PartTime Employees ->{}", employeeRepository.partTimeRetrive());
		

	}
}
