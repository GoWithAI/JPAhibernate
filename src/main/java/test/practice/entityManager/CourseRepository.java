package test.practice.entityManager;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional // on single object we are doing retrieve then Delete which leads exception with
				// this annotation we are avoiding exception.
public class CourseRepository {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public Course save(Course course) {
		// Create
		if (course.getId() == null) {
			em.persist(course);// save
		} else {
			em.merge(course);// Update
		}
		return course;
	}

	public void deleteById(Long id) {
		Course course = em.find(Course.class, id);
		em.remove(course);
	}

	public void playWithEntityManager() {
		Course course = new Course("Web Service");
		em.persist(course);
		em.flush(); // flush AUTO - (Default) Flushing to occur at query execution.
		// when you call EntityManager.flush(), queries for inserting/updating/deleting
		// associated entities are executed in the database
		// behaviour depends on whether flush-mode is AUTO or COMMIT.
		// FlushModeType: AUTO or COMMIT.
		// COMMIT -
		// If there is no transaction active or the persistence context is not joined to
		// the current transaction, the persistence provider must not flush to the
		// database.
		// Flushing to occur at transaction commit. The provider may flush at other
		// times, but is not required to.
		course.setName("Web Service Updated!!!!!");// If bean is within Entity manager transaction(@Transactional) then
													// it keep tract of Entity(CUD)
													// any change CREATE,UPDATE,DELETE in Entity Manager and Persist
													// changes into database
													// - Here data will per persisted/Updated to DB
		Course course2 = new Course("Angular");
		em.persist(course2);// if Entity is not flushed then Entity will be inserted after transaction
							// commit
		em.flush();// Since Entity is flushed course 2 will inserted now in DB

		em.detach(course2);// Remove the given entity from the persistence context,After this Flushing will
							// work

		course2.setName("Angular Updated!!!!");
		em.flush();// data will persist since entity is already detached

		Course course3 = new Course("Spring");
		em.persist(course3);
		Course course4 = new Course("Hibernate");
		em.persist(course4);

		em.clear();// Clear the persistence context, causing all managed entities to
		// become
		// detached. Changes made to entities that have not been flushed to the database
		// will not be persisted.
		// After detached Entity from current Entity manager any entity will not
		// persist/flush
		// to DB
		course3.setName("Spring Updated!!!!");
		course4.setName("Hibernate Updated!!!!!");

		Course course5 = new Course("Spring 5");
		em.persist(course5);
		Course course6 = new Course("Hibernate 6");
		em.persist(course6);

		em.flush();// insert  
		course5.setName("Spring 5 updated!");
		course6.setName("Hibernate 6 updated!!");// After Flush if system fails here then also @Transaction will roll back all above changes 

		em.refresh(course5);// get Data value back into entity from DB
		// if New entity is not updated/flushed/exist into DB the we will get
		// javax.persistence.EntityNotFoundException
		// Here "Spring 5" will be persisted
		em.flush();

	}
}
