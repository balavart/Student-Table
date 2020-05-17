package balayan.studenttable.service;

import balayan.studenttable.model.Student;
import balayan.studenttable.repo.StudentRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * The type Student service.
 *
 * @author Vardan Balaian
 * @created 16.05.2020
 * @since 1.8
 */
@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepo studentRepo;

  /**
   * Instantiates a new Student service.
   *
   * @param studentRepo the student repository
   */
  @Autowired
  public StudentServiceImpl(StudentRepo studentRepo) {
    this.studentRepo = studentRepo;
  }

  @Override
  public Iterable<Student> getAllStudents() {
    return studentRepo.findAll();
  }

  @Override
  public void saveStudent(Student student) {
    if (!student.getSurname().trim().isEmpty()
        && !student.getName().trim().isEmpty()
        && !student.getPatronymic().trim().isEmpty()) {
      studentRepo.save(student);
    }
  }

  @Override
  public void deleteStudent(Long id) {
    studentRepo.deleteById(id);
  }

  @Override
  public void editStudent(
      Long studentId,
      String surname,
      String name,
      String patronymic,
      Integer assessment,
      Integer studentGroup) {
    Student modifiedStudent = studentRepo.getById(studentId);
    String modifiedSurname =
        Optional.ofNullable(surname).isPresent() && !surname.isEmpty() && !surname.trim().isEmpty()
            ? surname
            : modifiedStudent.getSurname();
    String modifiedName =
        Optional.ofNullable(name).isPresent() && !name.isEmpty() && !name.trim().isEmpty()
            ? name
            : modifiedStudent.getName();
    String modifiedPatronymic =
        Optional.ofNullable(patronymic).isPresent()
                && !patronymic.isEmpty()
                && !patronymic.trim().isEmpty()
            ? patronymic
            : modifiedStudent.getPatronymic();
    Integer modifiedAssessment =
        Optional.ofNullable(assessment).isPresent() ? assessment : modifiedStudent.getAssessment();
    Integer modifiedStudentGroup =
        Optional.ofNullable(studentGroup).isPresent()
            ? studentGroup
            : modifiedStudent.getStudentGroup();

    modifiedStudent.setSurname(modifiedSurname);
    modifiedStudent.setName(modifiedName);
    modifiedStudent.setPatronymic(modifiedPatronymic);
    modifiedStudent.setAssessment(modifiedAssessment);
    modifiedStudent.setStudentGroup(modifiedStudentGroup);

    studentRepo.save(modifiedStudent);
  }

  @Override
  public List<Student> getSortedStudentsBySurname() {
    return studentRepo.findAll(Sort.by(Sort.Order.asc("surname").ignoreCase()));
  }

  @Override
  public List<Student> getSortedStudentsByName() {
    return studentRepo.findAll(Sort.by(Sort.Order.asc("name").ignoreCase()));
  }

  @Override
  public List<Student> getSortedStudentsByPatronymic() {
    return studentRepo.findAll(Sort.by(Sort.Order.asc("patronymic").ignoreCase()));
  }

  @Override
  public List<Student> getSortedStudentsByAssessment() {
    return studentRepo.findAllByOrderByAssessmentAsc();
  }

  @Override
  public List<Student> getSortedStudentsByStudentGroup() {
    return studentRepo.findAllByOrderByStudentGroupAsc();
  }
}
