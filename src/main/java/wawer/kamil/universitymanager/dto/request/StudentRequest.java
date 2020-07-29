package wawer.kamil.universitymanager.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import wawer.kamil.universitymanager.model.Course;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentRequest {

    private String firstName;
    private String lastName;
    private LocalDate joinToUniversityDate;
    private Set<Course> joinedCourses;
}
