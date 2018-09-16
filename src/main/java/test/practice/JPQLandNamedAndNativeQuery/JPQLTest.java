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
public class JPQLTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
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
	}
	
	@Test
	public void findJpqlWhere() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c where name like 'Ja%'", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("findJpqlWhere -> {} " + resultList);
	}
}
