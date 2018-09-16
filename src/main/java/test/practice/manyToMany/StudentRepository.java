package test.practice.manyToMany;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class StudentRepository {

	/*	private final Logger log = LoggerFactory.getLogger(this.getClass());*/	

	@Autowired
	EntityManager em;

	/*	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {
		// Create
		if (student.getId() == null) {
			em.persist(student);// save
		} else {
			em.merge(student);// Update
		}
		return student;
	}

	public void deleteById(Long id) {
		Student student = em.find(Student.class, id);
		em.remove(student);
	}

	public void saveStudentWithPassport() {

		Passport passport = new Passport("Passport");
		em.persist(passport);

		Student student = new Student("Student");
		student.setPassport(passport);

		em.persist(student);

	}*/

	/*public void somePersistenceContextOperation() {
		// 1 retrive student info
		Student student = em.find(Student.class, 20001L);

		// 2 retrive passport info
		Passport passport = student.getPassport();

		// 3 update passport
		passport.setNumber("Passport Updated!!");

		// 4 update student
		student.setName("Student Name Updated!!");
	}*/
	
	public void insertHardcodedStudentAndCourse(){
		Student student=new Student("Durga");
		Course course=new Course("Java ,Spring, Hibernate");
		
		em.persist(student);
		em.persist(course);
		
		//student.addCourse(course);
		//course.addStudent(student);
		//em.persist(student);
		
		
	}
	public void insertStudentAndCourse(Student student,Course course){
		em.persist(student);
		em.persist(course);
		student.addCourse(course);
	}
	
	//Course Java < Preeti
	public void insertStudentInCourse(Student student,Long courseId){
		Course course=em.find(Course.class, courseId);
		em.persist(student);
		course.addStudent(student);
		student.addCourse(course);
		//em.persist(course);
	}
	
	// Durga > Spring
	public void insertCourseInStudent(Long studentId,Course course){
		Student student=em.find(Student.class, studentId);
		em.persist(course);
		student.addCourse(course);
		em.persist(student);		
	}
}