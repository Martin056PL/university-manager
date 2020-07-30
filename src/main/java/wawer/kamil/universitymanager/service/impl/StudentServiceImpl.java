package wawer.kamil.universitymanager.service.impl;

import lombok.RequiredArgsConstructor;
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
import wawer.kamil.universitymanager.utils.mapper.ModelMapperHelper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentsGenerator studentsGenerator;
    private final ModelMapperHelper modelMapperHelper;

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> studentsEntities = Optional.of(studentRepository.findAll()).orElseThrow(() -> new NotFoundException("Not Found"));
        return modelMapperHelper.mapListOfStudentsEntitiesToListOfStudentsResponse(studentsEntities);
    }

    @Override
    public StudentResponse getStudentById(String id) {
        Student studentEntities = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found"));
        return modelMapperHelper.mapStudentEntityToStudentResponse(studentEntities);
    }

    @Override
    public List<StudentResponse> getPaginatedListOfStudents(Integer size, Integer page) {
        Pageable pageableSettings = PageRequest.of(page, size);
        Page<Student> pageResults = studentRepository.findAll(pageableSettings);
        List<Student> studentsEntitiesList = pageResults.getContent();
        return modelMapperHelper.mapListOfStudentsEntitiesToListOfStudentsResponse(studentsEntitiesList);
    }

    @Override
    public void generateRandomStudents() {
        studentRepository.saveAll(studentsGenerator.getList());
    }

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student studentEntity = modelMapperHelper.mapStudentRequestToStudentEntity(studentRequest);
        Student savedStudent = studentRepository.save(studentEntity);
        return modelMapperHelper.mapStudentEntityToStudentResponse(savedStudent);
    }

    @Override
    public StudentResponse updateStudentById(String id, StudentRequest studentRequest) {
        Student studentFromRequest = modelMapperHelper.mapStudentRequestToStudentEntity(studentRequest);
        if (!studentRepository.existsById(id)) {
            throw new NotFoundException("Not Found");
        }
        studentFromRequest.setId(id);
        Student savedStudentEntity = studentRepository.save(studentFromRequest);
        return modelMapperHelper.mapStudentEntityToStudentResponse(savedStudentEntity);
    }

    @Override
    public void deleteStudentById(String id) {
        if (!studentRepository.existsById(id)) {
            throw new NotFoundException("Not Found");
        }
        studentRepository.deleteById(id);
    }
}
