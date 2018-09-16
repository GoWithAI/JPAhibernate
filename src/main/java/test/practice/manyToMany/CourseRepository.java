package test.practice.manyToMany;

import java.util.List;

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

	public void addReviewForCoruse() {
		// Retrive coruse 20003
		Course course = findById(30001L);
		log.info("{} addReviewForCoruse -> " + course.getReview());
		
		// Add 2 review to it
		Review review1=new Review("5","Great Hands on stuff");
		Review review2=new Review("6","Hats Off");
		
		//setting the relationship ?
		course.addReview(review1);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		// save into database
		em.persist(review1);
		em.persist(review2);
		

	}
	
	/*public void addReviewForCourseGeneralized(Long courseId,List<Review> reveiws) {
		Course course = findById(courseId);
		log.info("{} addReviewForCoruse -> " + course.getReview());
		
		for(Review review : reveiws) {
		course.addReview(review);
		review.setCourse(course);
		em.persist(review);
		}

	}*/
}
