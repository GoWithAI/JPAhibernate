package test.practice.InheritanceStrategyAndJpql;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class EmployeeRepository {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	//insert 
	public void insert(Employee  employee) {
		em.persist(employee);
	}
	//retrive
	public List<FullTimeEmployee> fullTimeRetrive() {
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
	
	public List<PartTimeEmployee> partTimeRetrive() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	
}
