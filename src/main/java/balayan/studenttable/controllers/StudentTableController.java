package balayan.studenttable.controllers;

import balayan.studenttable.model.Student;
import balayan.studenttable.service.StudentService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * The type Student table controller.
 *
 * @author Vardan Balaian
 * @created 15.05.2020
 * @since 1.8
 */
@RestController
public class StudentTableController {

  private final StudentService studentService;

  @Value("${myproperty.students}")
  private String studentList;

  @Value("${myproperty.students.studentsNumber}")
  private String studentsNumber;

  @Value("${myproperty.student_table.url}")
  private String studentTableURL;

  @Value("${myproperty.main_page.url}")
  private String mainPageURL;

  /**
   * Instantiates a new Student table controller.
   *
   * @param studentService the student service
   */
  @Autowired
  public StudentTableController(StudentService studentService) {
    this.studentService = studentService;
  }

  /** Gets all students. */
  @RequestMapping("/")
  public ModelAndView getStudents(ModelAndView modelAndView) {

    val students = studentService.getAllStudents();
    val studentNumber = students.spliterator().getExactSizeIfKnown();

    modelAndView.addObject(studentList, students);
    modelAndView.addObject(studentsNumber, studentNumber);
    modelAndView.setViewName(studentTableURL);

    return modelAndView;
  }

  /**
   * Add student and redirect view.
   *
   * @param newStudent the new student
   * @return redirect view
   */
  @RequestMapping("/addStudent")
  public RedirectView addStudent(Student newStudent) {
    studentService.saveStudent(newStudent);

    return new RedirectView(mainPageURL);
  }

  /**
   * Delete student and redirect view.
   *
   * @param studentIdForDelete the student id for delete
   * @return redirect view
   */
  @RequestMapping("/deleteStudent")
  public RedirectView deleteStudent(@RequestParam Long studentIdForDelete) {
    studentService.deleteStudent(studentIdForDelete);

    return new RedirectView(mainPageURL);
  }

  /**
   * Edit student and redirect view.
   *
   * @param studentIdForEditing the student id for editing
   * @param newSurname the new surname
   * @param newName the new name
   * @param newPatronymic the new patronymic
   * @param newAssessment the new assessment
   * @param newStudentGroup the new student group
   * @return redirect view
   */
  @RequestMapping("/editStudent")
  public RedirectView editStudent(
      @RequestParam Long studentIdForEditing,
      @RequestParam String newSurname,
      @RequestParam String newName,
      @RequestParam String newPatronymic,
      @RequestParam Integer newAssessment,
      @RequestParam Integer newStudentGroup) {
    studentService.editStudent(
        studentIdForEditing, newSurname, newName, newPatronymic, newAssessment, newStudentGroup);

    return new RedirectView(mainPageURL);
  }

  /** Gets all students by surname. */
  @RequestMapping("/sortBySurname")
  public ModelAndView getStudentsBySurname(ModelAndView modelAndView) {

    val students = studentService.getSortedStudentsBySurname();
    val studentListSize = students.size();

    modelAndView.addObject(studentList, students);
    modelAndView.addObject(studentsNumber, studentListSize);
    modelAndView.setViewName(studentTableURL);

    return modelAndView;
  }

  /** Gets all students by name. */
  @RequestMapping("/sortByName")
  public ModelAndView getStudentsByName(ModelAndView modelAndView) {

    val students = studentService.getSortedStudentsByName();
    val studentListSize = students.size();

    modelAndView.addObject(studentList, students);
    modelAndView.addObject(studentsNumber, studentListSize);
    modelAndView.setViewName(studentTableURL);

    return modelAndView;
  }

  /** Gets all students by patronymic. */
  @RequestMapping("/sortByPatronymic")
  public ModelAndView getStudentsByPatronymic(ModelAndView modelAndView) {

    val students = studentService.getSortedStudentsByPatronymic();
    val studentListSize = students.size();

    modelAndView.addObject(studentList, students);
    modelAndView.addObject(studentsNumber, studentListSize);
    modelAndView.setViewName(studentTableURL);

    return modelAndView;
  }

  /** Gets all students by assessment. */
  @RequestMapping("/sortByAssessment")
  public ModelAndView getStudentsByAssessment(ModelAndView modelAndView) {

    val students = studentService.getSortedStudentsByAssessment();
    val studentListSize = students.size();

    modelAndView.addObject(studentList, students);
    modelAndView.addObject(studentsNumber, studentListSize);
    modelAndView.setViewName(studentTableURL);

    return modelAndView;
  }

  /** Gets all students by student group number. */
  @RequestMapping("/sortByStudentGroup")
  public ModelAndView getStudentsByStudentGroup(ModelAndView modelAndView) {

    val students = studentService.getSortedStudentsByStudentGroup();
    val studentListSize = students.size();

    modelAndView.addObject(studentList, students);
    modelAndView.addObject(studentsNumber, studentListSize);
    modelAndView.setViewName(studentTableURL);

    return modelAndView;
  }
}
