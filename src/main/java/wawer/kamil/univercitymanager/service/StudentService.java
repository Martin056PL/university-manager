package wawer.kamil.univercitymanager.service;

import wawer.kamil.univercitymanager.dto.request.StudentRequest;
import wawer.kamil.univercitymanager.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(String id);

    StudentResponse saveStudent(StudentRequest studentRequest);

    StudentResponse updateStudentById(String id, StudentRequest studentRequest);
}
