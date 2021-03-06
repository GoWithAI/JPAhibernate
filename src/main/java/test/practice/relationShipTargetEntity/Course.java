package test.practice.relationShipTargetEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "full_name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "course", targetEntity = Review.class) // ,fetch=FetchType.EAGER) //One to Many side default
																	// is Lazy Loading
	// em.find(Course.class, id);
	// targetEntity If Instace Variable of collection does not have Generic Type
	// like List<Review> review = new ArrayList<>();
	private List review = new ArrayList();

	@OneToMany(mappedBy = "course",targetEntity =FullTimeEmployee.class)
	private List<Employee> employee = new ArrayList<>();// List type Target entity Employee- can be any super
														// concrete class,Interface,Abstract class but if mappedBy is
														// not available in it then need to define Implementation Target
														// entity

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

}