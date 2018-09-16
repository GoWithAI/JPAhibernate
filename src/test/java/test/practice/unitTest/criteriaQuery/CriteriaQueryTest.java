package test.practice.unitTest.criteriaQuery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import test.practice.criteriaQuery.Course;
import test.practice.criteriaQuery.DemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CriteriaQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void all_courses() {
		// "Select c From Course c"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		// Root<Course> courseRoot =
		// em.getCriteriaBuilder().createQuery(Course.class).from(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder

		// 4. Add Predicates etc to the Criteria Query

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();

		logger.info("Criteria Typed Query -> {}", resultList);

	}

	@Test
	public void all_courses_having_100Steps() {
		// "Select c From Course c where name like '%100 Steps' "

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class); // from Course

		// 3. Define Predicates etc using Criteria Builder
		Predicate like = cb.like(courseRoot.get("name"), "%Course1%"); // name like '%100 Steps
		// 4. Add Predicates etc to the Criteria Query
		cq.where(like);// Course c where name like '%100 Steps'

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));// "Select c From Course c where name like
																			// '%100 Steps' "

		List<Course> resultList = query.getResultList();

		logger.info("Like Course Typed Query -> {}", resultList);
	}

	@Test
	public void all_courses_without_students() {
		// "Select c From Course c where c.students is empty"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Predicate empty = cb.isEmpty(courseRoot.get("students")); // c.students is empty

		// 4. Add Predicates etc to the Criteria Query - Course c where c.students is
		// empty
		cq.where(empty);

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();
		logger.info("Not Student Course Typed Query -> {}", resultList);
	}

	@Test
	public void join() {
		// "Select c From Course c join c.students s"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students");
		// 4. Add Predicates etc to the Criteria Query

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();
		logger.info("Size - Join Course-Students Typed Query -> {}", resultList.size());
		logger.info("Join Course-Students Typed Query -> {}", resultList);
	}

	@Test
	public void left_join() {
		// "Select c From Course c left join c.students s"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Join<Object, Object> leftJoin = courseRoot.join("students",JoinType.RIGHT);
		// 4. Add Predicates etc to the Criteria Query
		
		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query= em.createQuery(cq.select(courseRoot));
		
		List<Course> resultList = query.getResultList();
		logger.info("Size - Join Course-Students Typed Query -> {}", resultList.size());
		logger.info("LEFT Typed Query -> {}",resultList);
		
	}
}
