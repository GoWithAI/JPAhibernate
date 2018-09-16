package test.practice.manyToMany;

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
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//courseRepository.addReviewForCoruse();
		/*List<Review> reviews=new  ArrayList<>();
		
		reviews.add(new Review("7","Cool"));
		reviews.add(new Review("007","Cool"));
		
		courseRepository.addReviewForCourseGeneralized(30001L, reviews);*/
		
		//studentRepository.insertHardcodedStudentAndCourse();
		studentRepository.insertStudentAndCourse(new Student("Durga"), new Course("Hibernate"));
		//studentRepository.insertStudentInCourse(new Student("DEEPAK"), 20001L);
		studentRepository.insertCourseInStudent(20002L, new Course("MVC"));
	}
}
