package test.practice.manyToMany;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Course")
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "full_name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "course") // ,fetch=FetchType.EAGER) //One to Many side default is Lazy Loading
									// em.find(Course.class, id);
	private List<Review> review = new ArrayList<>();

	@ManyToMany(mappedBy = "course")
	private List<Student> students = new ArrayList<>();

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Review> getReview() {
		return review;
	}

	// add review
	public void addReview(Review review) {
		this.review.add(review);
	}

	// remove review
	public void removeReview(Review review) {
		this.review.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}