package wawer.kamil.univercitymanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wawer.kamil.univercitymanager.dto.request.StudentRequest;
import wawer.kamil.univercitymanager.dto.response.StudentResponse;
import wawer.kamil.univercitymanager.service.StudentService;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping
    public ResponseEntity<StudentResponse> saveStudent(@RequestBody StudentRequest studentRequest) throws URISyntaxException {
        StudentResponse response = studentService.saveStudent(studentRequest);
        return ResponseEntity.created(new URI("http://localhost:8080/rest/student/" + response.getId())).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudentById(@PathVariable String id, @RequestBody StudentRequest studentRequest){
        return ResponseEntity.ok(studentService.updateStudentById(id, studentRequest));
    }
}
