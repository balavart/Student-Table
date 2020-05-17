package balayan.studenttable.repo;

import balayan.studenttable.model.Student;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Student repository.
 *
 * @author Vardan Balaian
 * @created 16.05.2020
 * @since 1.8
 */
@Repository
@Transactional
public interface StudentRepo extends CrudRepository<Student, Integer> {

  List<Student> findAll();

  /**
   * Gets sorted list of students.
   *
   * @return the sorted list of students
   */
  List<Student> findAll(Sort title);

  /** Delete student by id. */
  void deleteById(Long id);

  /** Gets student by id. */
  Student getById(Long id);

  /**
   * Gets sorted list of students.
   *
   * @return the sorted by assessment list of students
   */
  List<Student> findAllByOrderByAssessmentAsc();

  /**
   * Gets sorted list of students.
   *
   * @return the sorted by student's group list of students;
   */
  List<Student> findAllByOrderByStudentGroupAsc();
}
