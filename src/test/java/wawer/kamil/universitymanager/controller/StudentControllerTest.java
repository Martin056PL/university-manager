package wawer.kamil.universitymanager.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import wawer.kamil.universitymanager.dto.request.StudentRequest;
import wawer.kamil.universitymanager.dto.response.StudentResponse;
import wawer.kamil.universitymanager.service.impl.StudentServiceImpl;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {


    @Mock
    StudentServiceImpl studentService;

    @Mock
    List<StudentResponse> studentResponseList;

    @Mock
    StudentResponse studentResponse;

    @Mock
    StudentRequest studentRequest;

    @InjectMocks
    StudentController studentController;

    private static final String STUDENT_ID = "id";
    private static final Integer SIZE_OF_PAGE = 1;
    private static final Integer PAGE_NUMBER = 1;
    private static final String GENERATED_VALUE = "Generated";

    //getAllStudents()
    @Test
    public void should_return_status_ok_when_controller_returns_all_students() {
        assertEquals(HttpStatus.OK, studentController.getAllStudents().getStatusCode());
    }

    @Test
    public void should_call_getAllStudent_method_once_when_call_this_method() {
        studentController.getAllStudents();
        verify(studentService,times(1)).getAllStudents();
    }

    @Test
    public void should_return_list_of_students_when_controller_call_getAllStudent_method() {
        when(studentService.getAllStudents()).thenReturn(Collections.singletonList(studentResponse));
        assertEquals(Collections.singletonList(studentResponse), studentController.getAllStudents().getBody());
    }

    //getStudentById()
    @Test
    public void should_return_status_ok_when_controller_returns_student_with_proper_id() {
        assertEquals(HttpStatus.OK, studentController.getStudentById(STUDENT_ID).getStatusCode());
    }

    @Test
    public void should_call_getStudentById_method_once_when_call_this_method(){
        studentController.getStudentById(STUDENT_ID);
        verify(studentService,times(1)).getStudentById(STUDENT_ID);
    }

    @Test
    public void should_return_body_response_equal_to_student_when_call_getStudentById() {
        when(studentService.getStudentById(STUDENT_ID)).thenReturn(studentResponse);
        assertEquals(studentResponse, studentController.getStudentById(STUDENT_ID).getBody());
    }

    //getPaginatedListOfStudents()
    @Test
    public void should_return_status_ok_when_controller_returns_paginated_list_of_students() {
        assertEquals(HttpStatus.OK, studentController.getPaginatedListOfStudents(SIZE_OF_PAGE, PAGE_NUMBER).getStatusCode());
    }

    @Test
    public void should_use_getPaginatedListOfStudents_method_once_when_call_this_method(){
        studentController.getPaginatedListOfStudents(SIZE_OF_PAGE,PAGE_NUMBER);
        verify(studentService,times(1)).getPaginatedListOfStudents(SIZE_OF_PAGE,PAGE_NUMBER);
    }

    @Test
    public void should_return_body_response_equal() {
        when(studentService.getPaginatedListOfStudents(SIZE_OF_PAGE, PAGE_NUMBER)).thenReturn(studentResponseList);
        assertEquals(studentResponseList, studentController.getPaginatedListOfStudents(SIZE_OF_PAGE, PAGE_NUMBER).getBody());
    }

    //generateRandomStudents()
    @Test
    public void should_return_proper_notification_when_controller_generate_random_students() {
        assertEquals(GENERATED_VALUE, studentController.generateRandomStudents().getBody());
    }

    @Test
    public void should_call_generateRandomStudents_method_once_when_call_this_method() {
        studentController.generateRandomStudents();
        verify(studentService, times(1)).generateRandomStudents();
    }

    @Test
    public void should_return_status_ok_when_controller_generate_random_students() {
        assertEquals(HttpStatus.OK, studentController.generateRandomStudents().getStatusCode());
    }

    //saveStudent()

    @Test
    public void should_return_saved_student_when_controller_saving_student() throws URISyntaxException {
        when(studentService.saveStudent(studentRequest)).thenReturn(studentResponse);
        assertEquals(studentResponse, studentController.saveStudent(studentRequest).getBody());
    }

    @Test
    public void should_call_saveStudent_method_once_when_call_this_method() throws URISyntaxException {
        when(studentService.saveStudent(studentRequest)).thenReturn(studentResponse);
        studentController.saveStudent(studentRequest);
        verify(studentService, times(1)).saveStudent(studentRequest);
    }

    @Test
    public void should_return_status_ok_when_controller_saving_new_student() throws URISyntaxException {
        when(studentService.saveStudent(studentRequest)).thenReturn(studentResponse);
        assertEquals(HttpStatus.CREATED, studentController.saveStudent(studentRequest).getStatusCode());
    }

    //updateStudentById

    @Test
    public void should_return_updated_student_when_controller_updating_student_by_id(){
        when(studentService.updateStudentById(STUDENT_ID, studentRequest)).thenReturn(studentResponse);
        assertEquals(studentResponse, studentController.updateStudentById(STUDENT_ID, studentRequest).getBody());
    }

    @Test
    public void should_call_updateStudentById_method_once_when_call_this_method(){
        when(studentService.updateStudentById(STUDENT_ID, studentRequest)).thenReturn(studentResponse);
        studentController.updateStudentById(STUDENT_ID,studentRequest);
        verify(studentService, times(1)).updateStudentById(STUDENT_ID, studentRequest);
    }

    @Test
    public void should_return_status_ok_when_controller_update_student_by_id(){
        when(studentService.updateStudentById(STUDENT_ID, studentRequest)).thenReturn(studentResponse);
        assertEquals(HttpStatus.OK, studentController.updateStudentById(STUDENT_ID, studentRequest).getStatusCode());
    }

    //deleteStudentById
    @Test
    public void should_return_empty_body_response_when_controller_deleting_student_by_id(){
        assertNull(studentController.deleteStudentById(STUDENT_ID).getBody());
    }

    @Test
    public void should_call_deleteStudentById_method_once_when_call_this_method(){
        studentController.deleteStudentById(STUDENT_ID);
        verify(studentService, times(1)).deleteStudentById(STUDENT_ID);
    }

    @Test
    public void should_return_status_no_content_when_controller_deleting_student_by_id(){
        assertEquals(HttpStatus.NO_CONTENT, studentController.deleteStudentById(STUDENT_ID).getStatusCode());
    }

}