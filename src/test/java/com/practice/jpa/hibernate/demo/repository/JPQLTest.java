package com.practice.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import test.practice.DemoApplication;
import test.practice.InheritanceStrategyAndJpql.Course;
import test.practice.InheritanceStrategyAndJpql.Student;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class JPQLTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	/*@Test
	public void findAll() {
		List resultList = em.createQuery("Select c From Course c").getResultList();
		log.info("Select c From Course c -> {} " + resultList);
	}

	@Test
	public void findAllWithQuery() {
		Query query = em.createQuery("Select c From Course c");
		List resultList = query.getResultList();
		log.info("findAllWithQuery -> {} " + resultList);
	}

	//Better Aprroach
	@Test
	public void findAllWithTypedQuery() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("findAllWithTypedQuery -> {} " + resultList);
	}*/
	
	@Test
	public void jpql_without_student() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("jpql_without_student -> {} " + resultList);
	}

	@Test
	public void jpql_studentwith_atleast_two_course() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c where size(c.students)>=2", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("jpql_studentwith_atleast_two_course -> {} " + resultList);
	}

	@Test
	public void jpql_ordered_by_student() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c order by size(c.students) desc", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("jpql_ordered_by_student -> {} " + resultList);
	}
	
	@Test
	public void jpql_students_passport_like_pattern() {
		TypedQuery<Student> query = em.createQuery("Select s From Student s where s.passport.number like '%123%'", Student.class);
		List<Student> resultList = query.getResultList();
		log.info("jpql_students_passport_like_pattern -> {} " + resultList);
	}
	
	@Test
	public void jpql_Inner_join() {//Inner Join - course_id = student_id
		Query query = em.createQuery("Select c,s From Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		
		for(Object[] result : resultList) {
			log.info("size -> {} "+ resultList.size() );
			log.info("jpql_Inner_join -> {} " + result[0] +"  "+ result[1]);	
		}
		
	}
	
	@Test
	public void jpql_left_join() {//Left Join - course_id = student_id and All Course
		Query query = em.createQuery("Select c,s From Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("size -> {} "+ resultList.size() );
		
		for(Object[] result : resultList) {
			
			log.info("jpql_left_join -> {} " + result[0] +"  "+ result[1]);	
		}
		
	}
	
	@Test
	public void jpql_cross_join() {//Left Join - course_id = student_id and All Course
		Query query = em.createQuery("Select c,s From Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		log.info("size -> {} "+ resultList.size() );
		
		for(Object[] result : resultList) {
			
			log.info("jpql_cross_join -> {} " + result[0] +"  "+ result[1]);	
		}
		
	}
}
