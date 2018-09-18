package test.practice.springDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

	List<Course> findByNameAndId(String name, Long id);

	List<Course> findByName(String name);

	List<Course> countByName(Long id);

	List<Course> findByNameOrderByIdDesc(String name);

	List<Course> deleteByName(String name);

	// JPQL Query
	@Query("Select c From Course c where name like 'Ja%'")
	List<Course> courseWithName();

	@Query(value = "Select c From Course c where name like 'Ja%'", nativeQuery = true)
	List<Course> courseWithNameUsingNativeQuery();
	
	@Query(name = "get_course_where")
	List<Course> courseWithNameUsingNamedQuery();

}
