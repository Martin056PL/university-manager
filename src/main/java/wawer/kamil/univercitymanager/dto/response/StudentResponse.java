package wawer.kamil.univercitymanager.dto.response;

import lombok.Data;
import wawer.kamil.univercitymanager.model.Course;

import java.time.LocalDate;
import java.util.Set;

@Data
public class StudentResponse {

    private String firstName;
    private String lastName;
    private LocalDate joinToUniversityDate;
    private Set<Course> joinedCours;
}
