package wawer.kamil.univercitymanager.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import wawer.kamil.univercitymanager.model.Course;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentResponse {

    private String id;
    private String firstName;
    private String lastName;
    private LocalDate joinToUniversityDate;
    private Set<Course> joinedCourses;
}
