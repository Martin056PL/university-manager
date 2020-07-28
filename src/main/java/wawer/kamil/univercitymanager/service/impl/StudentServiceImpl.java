package wawer.kamil.univercitymanager.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import wawer.kamil.univercitymanager.dto.request.StudentRequest;
import wawer.kamil.univercitymanager.dto.response.StudentResponse;
import wawer.kamil.univercitymanager.exceptions.NoFoundException;
import wawer.kamil.univercitymanager.model.Student;
import wawer.kamil.univercitymanager.repository.StudentRepository;
import wawer.kamil.univercitymanager.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> students = Optional.of(studentRepository.findAll()).orElse(new ArrayList<>());
        return students.stream().map(student -> modelMapper.map(student, StudentResponse.class)).collect(Collectors.toList());
    }

    @Override
    public StudentResponse getStudentById(String id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NoFoundException("Not Found"));
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student student = modelMapper.map(studentRequest, Student.class);
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentResponse.class);
    }

    @Override
    public StudentResponse updateStudentById(String id, StudentRequest studentRequest) {
        Student studentFromRequest = modelMapper.map(studentRequest, Student.class);
        if (studentRepository.existsById(id)) {
            studentFromRequest.setId(id);
            Student savedStudent = studentRepository.save(studentFromRequest);
            return modelMapper.map(savedStudent, StudentResponse.class);
        } else {
            throw new NoFoundException("Not Found");
        }
    }
}
