package wawer.kamil.universitymanager.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import wawer.kamil.universitymanager.dto.request.StudentRequest;
import wawer.kamil.universitymanager.dto.response.StudentResponse;
import wawer.kamil.universitymanager.exceptions.NotFoundException;
import wawer.kamil.universitymanager.model.Student;
import wawer.kamil.universitymanager.repository.StudentRepository;
import wawer.kamil.universitymanager.service.impl.StudentServiceImpl;
import wawer.kamil.universitymanager.utils.generator.student.StudentsGenerator;
import wawer.kamil.universitymanager.utils.mapper.ModelMapperHelper;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @Mock
    StudentRepository studentRepository;

    @Mock
    ModelMapperHelper modelMapperHelper;

    @Mock
    List<Student> studentList;

    @Mock
    List<StudentResponse> studentResponseList;

    @Mock
    Student student;

    @Mock
    StudentResponse studentResponse;

    @Mock
    Page<Student> pageResults;

    @Mock
    StudentsGenerator studentsGenerator;

    @Mock
    StudentRequest studentRequest;

    @InjectMocks
    StudentServiceImpl studentService;

    private static final String STUDENT_ID = "id";
    private static final Integer SIZE_OF_PAGE = 1;
    private static final Integer PAGE_NUMBER = 1;

    @Test
    public void should_return_list_of_response_students_when_call_getAllStudents_method() {
        when(studentRepository.findAll()).thenReturn(studentList);
        when(modelMapperHelper.mapListOfStudentsEntitiesToListOfStudentsResponse(studentList))
                .thenReturn(studentResponseList);
        assertEquals(studentResponseList, studentService.getAllStudents());
    }

    @Test
    public void should_verify_if_getAllStudent_method_calls_repository() {
        studentService.getAllStudents();
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void should_return_student_response_when_call_getStudentById_method() {
        when(studentRepository.findById(STUDENT_ID)).thenReturn(Optional.of(student));
        when(modelMapperHelper.mapStudentEntityToStudentResponse(student)).thenReturn(studentResponse);
        assertEquals(studentResponse, studentService.getStudentById(STUDENT_ID));
    }

    @Test(expected = NotFoundException.class)
    public void should_throw_notFoundException_when_student_with_passed_id_doesnt_exist_for_getStudentById() {
        when(studentRepository.findById(STUDENT_ID)).thenThrow(new NotFoundException("NotFound"));
        studentService.getStudentById(STUDENT_ID);
    }

    @Test
    public void should_verify_if_getStudentById_method_calls_repository() {
        when(studentRepository.findById(STUDENT_ID)).thenReturn(Optional.of(student));
        studentService.getStudentById(STUDENT_ID);
        verify(studentRepository, times(1)).findById(STUDENT_ID);
    }

    @Test
    public void should_return_paginated_list_of_students_when_call_getPaginatedListOfStudents_method() {
        Pageable pageableSettings = PageRequest.of(PAGE_NUMBER, SIZE_OF_PAGE);
        when(studentRepository.findAll(pageableSettings)).thenReturn(pageResults);
        when(pageResults.getContent()).thenReturn(studentList);
        when(modelMapperHelper.mapListOfStudentsEntitiesToListOfStudentsResponse(studentList))
                .thenReturn(studentResponseList);
        assertEquals(studentResponseList,
                studentService.getPaginatedListOfStudents(PAGE_NUMBER, SIZE_OF_PAGE));
    }

    @Test
    public void should_verify_if_getPaginatedListOfStudents_method_calls_repository() {
        Pageable pageableSettings = PageRequest.of(PAGE_NUMBER, SIZE_OF_PAGE);
        when(studentRepository.findAll(pageableSettings)).thenReturn(pageResults);
        studentService.getPaginatedListOfStudents(SIZE_OF_PAGE, PAGE_NUMBER);
        verify(studentRepository, times(1)).findAll(pageableSettings);
    }

    @Test
    public void should_verify_if_generateRandomStudents_method_calls_repository() {
        when(studentsGenerator.getList()).thenReturn(studentList);
        studentService.generateRandomStudents();
        verify(studentRepository, times(1)).saveAll(studentList);
    }

    @Test
    public void should_return_saved_student_response_when_call_saveStudent_method() {
        when(modelMapperHelper.mapStudentRequestToStudentEntity(studentRequest))
                .thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);
        when(modelMapperHelper.mapStudentEntityToStudentResponse(student))
                .thenReturn(studentResponse);
        assertEquals(studentResponse, studentService.saveStudent(studentRequest));
    }

    @Test
    public void should_verify_if_saveStudent_method_calls_repository() {
        when(modelMapperHelper.mapStudentRequestToStudentEntity(studentRequest))
                .thenReturn(student);
        studentService.saveStudent(studentRequest);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void should_return_updated_student_response_when_call_updateStudentById_method() {
        when(studentRepository.existsById(STUDENT_ID))
                .thenReturn(true);
        when(modelMapperHelper.mapStudentRequestToStudentEntity(studentRequest))
                .thenReturn(student);
        student.setId(STUDENT_ID);
        when(studentRepository.save(student))
                .thenReturn(student);
        when(modelMapperHelper.mapStudentEntityToStudentResponse(student))
                .thenReturn(studentResponse);
        assertEquals(studentResponse, studentService.updateStudentById(STUDENT_ID, studentRequest));
    }

    @Test
    public void should_verify_if_updateStudentById_method_calls_repository() {
        student.setId(STUDENT_ID);
        studentRepository.save(student);
        verify(studentRepository, times(1)).save(student);
    }

    @Test(expected = NotFoundException.class)
    public void should_throw_notFoundException_when_student_with_passed_id_doesnt_exist_for_updateStudentById() {
        when(studentRepository.existsById(STUDENT_ID))
                .thenReturn(false);
        studentService.updateStudentById(STUDENT_ID, studentRequest);
    }

    @Test
    public void should_verify_if_deleteStudentById_method_calls_repository() {
        when(studentRepository.existsById(STUDENT_ID))
                .thenReturn(true);
        studentService.deleteStudentById(STUDENT_ID);
        verify(studentRepository, times(1)).deleteById(STUDENT_ID);
    }

    @Test(expected = NotFoundException.class)
    public void should_throw_notFoundException_when_student_with_passed_id_doesnt_exist_for_deleteStudentById() {
        when(studentRepository.existsById(STUDENT_ID))
                .thenReturn(false);
        studentService.deleteStudentById(STUDENT_ID);
    }
}
