package test.practice.JPQLandNamedAndNativeQuery;

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


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class NamedQuery {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void findAll() {
		List resultList = em.createNamedQuery("get_all_course").getResultList();
		log.info("get_all_course-> {} " + resultList);
	}

	@Test
	public void findAllWithQuery() {
		Query query = em.createNamedQuery("get_all_course");
		List resultList = query.getResultList();
		log.info("findAllWithQuery -> {} " + resultList);
	}

	// Better Approach
	@Test
	public void findAllWithTypedQuery() {
		TypedQuery<Course> query = em.createNamedQuery("get_all_course", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("findAllWithTypedQuery -> {} " + resultList);
	}

	@Test
	public void findJpqlWhere() {
		TypedQuery<Course> query = em.createNamedQuery("get_course_where", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("findJpqlWhere -> {} " + resultList);
	}
}
