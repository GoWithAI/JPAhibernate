package test.practice.oneToOne;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	 @Transactional // If not Used Annotation - Exception :could not initialize
	// proxy
	// [com.practice.jpa.hibernate.demo.entity.Passport#40001] - no Session
	public void getPassportOfStudent() {
		Student student = entityManager.find(Student.class, 20001L);// If not @Transactional it will end transaction
																	// here
		log.info("Student {} ->", student);
		log.info("Student {} ->", student.getPassport());// If Two Entity are in relationship then and trying to access
															// other Entity then we need to begin Transaction again (So
															// we Use @Transactional)
	}

	@Test
	// @Transactional
	public void getStudentFromPassport() {
		Passport passport = entityManager.find(Passport.class, 40001L);
		log.info("Passport {} ->", passport);
		log.info("Student {} ->", passport.getStudent());
	}

	// @Test
	// @Transactional
	/*
	 * public void testOpeartion() { //
	 * studentRepository.somePersistenceContextOperation(); // 1 retrive student
	 * info Student student = entityManager.find(Student.class, 20001L);
	 * 
	 * // 2 retrive passport info Passport passport = student.getPassport();
	 * 
	 * // 3 update passport passport.setNumber("Passport Updated!!");
	 * 
	 * // 4 update student student.setName("Student Name Updated!!"); }
	 */

}
