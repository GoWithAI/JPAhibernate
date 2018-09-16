package test.practice.JPQLandNamedAndNativeQuery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
public class NativeQueryTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void nativeFindAll() {
		List resultList = em.createNativeQuery("Select * from course_details").getResultList();
		log.info("nativeFindAll-> {} " + resultList);
	}

	@Test
	public void nativeFindAllWithQuery() {
		Query query = em.createNativeQuery("Select * from course_details");
		List resultList = query.getResultList();
		log.info("nativeFindAllWithQuery -> {} " + resultList);
	}

	// Better Approach
	@Test
	public void nativeFindAllWhere() {
		Query query = em.createNativeQuery("Select * from course_details where id = ?", Course.class);
		query.setParameter(1, 1001L);
		List resultList = query.getResultList();
		log.info("nativeFindAllWhere -> {} " + resultList);
	}

	@Test
	public void nativeQueryWithNamedParameter() {
		Query query = em.createNativeQuery("select * from course_details where id = :id", Course.class);
		query.setParameter("id", 1001L);
		List resultList = query.getResultList();
		log.info("nativeQueryWithNamedParameter -> {} " + resultList);
	}

	//If we want to Execute Update or Delete Query then It should within Transaction
	@Test
	@Transactional
	public void nativeQueryUpdate() {
		Query query = em.createNativeQuery("update course_details set last_updated_date=sysdate()",
				Course.class);
		int noOfUpdatedRows = query.executeUpdate();
		log.info("nativeQueryUpdate -> {} " + noOfUpdatedRows);
	}
}
