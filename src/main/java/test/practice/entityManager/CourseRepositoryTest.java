package test.practice.entityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


import test.practice.entityManager.Course;
import test.practice.entityManager.CourseRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findByIdBasic() {
		Course course = courseRepository.findById(1001L);
		assertEquals("Java", course.getName());
	}

	@Test
	@DirtiesContext //All Changes are done Will be Rolled Back
	public void deleteByIdBasic() {
		courseRepository.deleteById(2001L);
		assertNull(courseRepository.findById(2001L));
	}

	/*@Test
	@DirtiesContext
	public void save() {
		// get a Course
		Course course = courseRepository.findById(1001L);
		assertEquals("Java", course.getName());

		// update Details
		course.setName("Java Updated");

		courseRepository.save(course);
		// check value
		Course course1 = courseRepository.findById(1001L);
		assertEquals("Java Updated", course1.getName());
	}*/

	@Test
	@DirtiesContext
	public void playingWithEnetiyManager() {
	courseRepository.playWithEntityManager();		
	}
}
