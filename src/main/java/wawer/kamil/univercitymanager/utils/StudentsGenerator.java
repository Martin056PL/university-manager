package wawer.kamil.univercitymanager.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import wawer.kamil.univercitymanager.model.Course;
import wawer.kamil.univercitymanager.model.Student;
import wawer.kamil.univercitymanager.repository.StudentRepository;

import java.time.LocalDate;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StudentsGenerator {

    private final StudentRepository studentRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void GenerateStudents() {

        studentRepository.deleteAll();
        Student student1 = new Student("Janusz"
                , "Marian"
                , LocalDate.of(2000, 10, 1)
                , Set.of(
                new Course("Analiza Matematyczna",
                        "Baśka",
                        true),
                new Course("Algebra",
                        "Ernest",
                        true)));
        studentRepository.save(student1);
    }
}
