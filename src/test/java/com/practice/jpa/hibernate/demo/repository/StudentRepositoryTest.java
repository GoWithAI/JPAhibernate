package com.practice.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import ch.qos.logback.core.net.SyslogOutputStream;
import test.practice.DemoApplication;
import test.practice.manyToMany.Student;
import test.practice.manyToMany.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager entityManager;

/*	@Test
	@Transactional
	public void retriveStudentAndCourses() {
		Student student = entityManager.find(Student.class, 20001L);
		log.info("Student {} ->", student);
		System.out.println(student);
		log.info("Student {} ->", student.getCourse());
		System.out.println(student.getCourse());
	}*/

	/*@Test
	@Transactional
	public void retriveCoursesAndStudent() {
		Course course = entityManager.find(Course.class, 10001L);
		log.info("Student {} ->", course);
		System.out.println(course);
		log.info("Student {} ->", course.getStudents());
		System.out.println(course.getStudents());
	}*/
	@Test
	//@Transactional
	public void retriveCoursesAndStudent() {
		studentRepository.insertStudentInCourse(new Student("DEEPAK"), 20001L);
	}
	
}
