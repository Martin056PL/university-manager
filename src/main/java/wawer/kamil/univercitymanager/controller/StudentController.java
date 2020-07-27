package wawer.kamil.univercitymanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wawer.kamil.univercitymanager.dto.response.StudentResponse;
import wawer.kamil.univercitymanager.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("rest/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public ResponseEntity<List<StudentResponse>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable String id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
}
