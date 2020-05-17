package balayan.studenttable.service;

import balayan.studenttable.model.Student;
import java.util.List;

/**
 * The interface Student service.
 *
 * @author Vardan Balaian
 * @created 16.05.2020
 * @since 1.8
 */
public interface StudentService {

  /** Gets all students. */
  Iterable<Student> getAllStudents();

  /** Save student to DB. */
  void saveStudent(Student student);

  /** Delete student from DB. */
  void deleteStudent(Long id);

  /**
   * Edit student by Id.
   *
   * @param studentId the student id
   * @param surname the surname
   * @param name the name
   * @param patronymic the patronymic
   * @param assessment the assessment
   * @param studentGroup the student group
   */
  void editStudent(
      Long studentId,
      String surname,
      String name,
      String patronymic,
      Integer assessment,
      Integer studentGroup);

  /** Gets sorted students by surname. */
  List<Student> getSortedStudentsBySurname();

  /** Gets sorted students by name. */
  List<Student> getSortedStudentsByName();

  /** Gets sorted students by patronymic. */
  List<Student> getSortedStudentsByPatronymic();

  /** Gets sorted students by assessment. */
  List<Student> getSortedStudentsByAssessment();

  /** Gets sorted students by student group. */
  List<Student> getSortedStudentsByStudentGroup();
}
