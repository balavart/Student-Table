package balayan.studenttable.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * The type Student.
 *
 * @author Vardan Balaian
 * @created 16.05.2020
 * @since 1.8
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NonNull private String surname;
  @NonNull private String name;
  @NonNull private String patronymic;
  @NonNull private Integer assessment;
  @NonNull private Integer studentGroup;
}
