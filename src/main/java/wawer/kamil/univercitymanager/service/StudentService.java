package wawer.kamil.univercitymanager.service;

import wawer.kamil.univercitymanager.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

    List<StudentResponse> getAllStudents();
}
