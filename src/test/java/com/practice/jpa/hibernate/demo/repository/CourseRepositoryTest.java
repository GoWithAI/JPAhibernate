package com.practice.jpa.hibernate.demo.repository;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import test.practice.DemoApplication;
import test.practice.manyToMany.Course;
import test.practice.manyToMany.CourseRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	CourseRepository courseRepository;
	
	@Test
	@Transactional
	public void retriveReviews() {
		Course course=courseRepository.findById(30001L);
		
		log.info("{}->"+course.getReview());
	}
	
}
