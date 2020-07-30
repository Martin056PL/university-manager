package wawer.kamil.universitymanager.service;

import wawer.kamil.universitymanager.dto.request.StudentRequest;
import wawer.kamil.universitymanager.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(String id);

    List<StudentResponse> getPaginatedListOfStudents(Integer size, Integer page);

    void generateRandomStudents();

    StudentResponse saveStudent(StudentRequest studentRequest);

    StudentResponse updateStudentById(String id, StudentRequest studentRequest);

    void deleteStudentById(String id);
}
