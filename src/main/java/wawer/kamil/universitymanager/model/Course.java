package wawer.kamil.universitymanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Indexed
    private String courseName;
    private String teacher;
    private boolean isCourseHasExam;

}
