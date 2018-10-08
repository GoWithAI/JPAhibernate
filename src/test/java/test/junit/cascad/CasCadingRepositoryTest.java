package test.junit.cascad;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import test.practice.DemoApplication;
import test.practice.cascad.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CasCadingRepositoryTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	@Test
	@Transactional
	public void retriveReviews() {
		// Course course=courseRepository.findById(30001L);
		Product product = entityManager.find(Product.class, 1);
		entityManager.remove(product);
		// log.info("{}->"+course.getReview());
	}

}
