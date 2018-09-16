package test.practice.unitTest.springData;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import test.practice.springDataJpa.Course;
import test.practice.springDataJpa.CourseSpringDataRepository;
import test.practice.springDataJpa.DemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository courseSpringDataRepository;

	@Test
	public void retriveExistedCourseById() {
		Optional<Course> course = courseSpringDataRepository.findById(20001L);
		assertTrue(course.isPresent());
		logger.info("Course Existed -> {}" + course.isPresent());
		logger.info("Course Existed -> {}" + course.get());
	}

	@Test
	public void retriveCoruseByIdWhichDoesNotExist() {
		Optional<Course> course = courseSpringDataRepository.findById(20009L);
		assertFalse(course.isPresent());
		// assertTrue(course.isPresent());
		logger.info("Course Not Existed -> {}" + course.isPresent());
		// logger.info("Course Not Existed -> {}" + course.get());
	}

	@Test
	public void saveUpdateRetriveAllOperation() {
		// New Course insert
		Course course = new Course("New Course !!!!");
		courseSpringDataRepository.save(course);

		course.setName("New Course Updated!!!!");
		courseSpringDataRepository.save(course);

		// Retrive All data
		logger.info("Course -> {}" + courseSpringDataRepository.findAll());
		logger.info("Course -> {}" + courseSpringDataRepository.count());

	}

	@Test
	public void sort() {
		Sort sort = new Sort(Sort.Direction.DESC, "name");
		logger.info("Sorted Course -> {}" + courseSpringDataRepository.findAll(sort));
	}

	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(1, 4);
		Page<Course> firstPage = courseSpringDataRepository.findAll(pageRequest);
		logger.info("First Page -> {}" + firstPage.getContent());
		
		Pageable secondPagable = firstPage.nextPageable();
		Page<Course> secondPage =courseSpringDataRepository.findAll(secondPagable);
		logger.info("Second Page -> {}" + secondPage.getContent());
	}

}
