package test.practice.springDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

	List<Course> findByNameAndId(String name, Long id);

	List<Course> findByName(String name);

	List<Course> countByName(String name);

	List<Course> findByNameOrderByIdDesc(String name);

	List<Course> deleteByName(String name);

	// JPQL Query
	@Query("Select c From Course c where name like 'Ja%'")
	List<Course> courseWithName();

	@Query(value = "Select * From Course c where full_name like 'Ja%'", nativeQuery = true)
	List<Course> courseWithNameUsingNativeQuery();
	
	@Query(name = "get_course_where")
	List<Course> courseWithNameUsingNamedQuery();

}
