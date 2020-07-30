package wawer.kamil.universitymanager.utils.generator.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import wawer.kamil.universitymanager.model.Course;
import wawer.kamil.universitymanager.model.Student;
import wawer.kamil.universitymanager.utils.generator.course.CourseGenerator;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StudentsGenerator {

    private final SecureRandom random;
    private final StudentJoinedDateGenerator studentJoinedDateGenerator;
    private final CourseGenerator courseGenerator;


    public List<Student> getList() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            studentList.add(generateStudent());
        }
        return studentList;
    }

    private Student generateStudent() {
        String firstName = DefaultStudentFirstNameMap.valueOf(random.nextInt(100)).toString();
        String lastName = DefaultStudentLastNameMap.valueOf(random.nextInt(100)).toString();
        LocalDate joinedDate = studentJoinedDateGenerator.generateJoiningDate();
        Set<Course> courses = generateSetOfCoursesForSingleStudent();
        return new Student(firstName, lastName, joinedDate, courses);
    }

    private Set<Course> generateSetOfCoursesForSingleStudent() {
        Set<Course> courseSet = new HashSet<>();
        for (int i = 0; i < random.nextInt(5) + 1; i++) {
            Course course = courseGenerator.generateCourse();
            courseSet.add(course);
        }
        return courseSet;
    }
}
