package wawer.kamil.univercitymanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@Document
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate joinToUniversityDate;
    private Set<Course> joinedCourses;

    public Student(String firstName, String lastName, LocalDate joinToUniversityDate, Set<Course> joinedCourses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinToUniversityDate = joinToUniversityDate;
        this.joinedCourses = joinedCourses;
    }
}
