package test.practice.enumWithType;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AutherRepository {
	
	@Autowired
	EntityManager em;
	
	@Transactional
	public void insertTest() {
		Auther auther = new Auther();
		auther.setAutherStatus(AutherStatus.NOT_PUBLISHED);
		auther.setGender(Gender.FEMALE);
		em.persist(auther);
		em.flush();
	}
}
