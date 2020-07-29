package wawer.kamil.universitymanager.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wawer.kamil.universitymanager.dto.request.StudentRequest;
import wawer.kamil.universitymanager.dto.response.StudentResponse;
import wawer.kamil.universitymanager.exceptions.NotFoundException;
import wawer.kamil.universitymanager.model.Student;
import wawer.kamil.universitymanager.repository.StudentRepository;
import wawer.kamil.universitymanager.service.StudentService;
import wawer.kamil.universitymanager.utils.generator.student.StudentsGenerator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentsGenerator studentsGenerator;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> students = Optional.of(studentRepository.findAll()).orElseThrow(() -> new NotFoundException("Not Found"));
        return students.stream().map(student -> modelMapper.map(student, StudentResponse.class)).collect(Collectors.toList());
    }

    @Override
    public StudentResponse getStudentById(String id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found"));
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
            throw new NotFoundException("Not Found");
        }
    }

    @Override
    public void deleteStudentById(String id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new NotFoundException("Not Found");
        }
    }

    @Override
    public void generateRandomStudents() {
        studentRepository.saveAll(studentsGenerator.getList());
    }

    @Override
    public List<StudentResponse> getPaginatedListOfStudents(Integer size, Integer page) {
        Pageable pageableSettings = PageRequest.of(page,size);
        Page<Student> pageResults = studentRepository.findAll(pageableSettings);
        List<Student> studentList = pageResults.getContent();
        return studentList.stream().map(student -> modelMapper.map(student, StudentResponse.class)).collect(Collectors.toList());
    }
}
