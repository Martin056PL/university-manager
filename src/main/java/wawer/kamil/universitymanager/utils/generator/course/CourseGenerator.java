package wawer.kamil.universitymanager.utils.generator.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import wawer.kamil.universitymanager.model.Course;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class CourseGenerator {

    private final Random random;
    private static final int BORDER_FOR_RANDOM_NUMBER_FOR_EXAM = 2;

    public Course generateCourse() {

        int randomNumberForCourseName = random.nextInt(DefaultCourseNameMap.values().length);
        int randomNumberForTeacher = random.nextInt(DefaultTeacherMap.values().length);
        int randomNumberForExam = random.nextInt(BORDER_FOR_RANDOM_NUMBER_FOR_EXAM);

        String courseName = DefaultCourseNameMap.valueOf(randomNumberForCourseName).toString();
        String teacher = DefaultTeacherMap.valueOf(randomNumberForTeacher).toString();
        boolean isCourseHasExam = IsCourseHasExamGenerator.GenerateIsCourseHasExam(randomNumberForExam);

        return new Course(courseName, teacher, isCourseHasExam);
    }
}
