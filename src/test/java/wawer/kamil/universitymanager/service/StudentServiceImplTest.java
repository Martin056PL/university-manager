package wawer.kamil.universitymanager.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import wawer.kamil.universitymanager.dto.request.StudentRequest;
import wawer.kamil.universitymanager.dto.response.StudentResponse;
import wawer.kamil.universitymanager.model.Student;
import wawer.kamil.universitymanager.repository.StudentRepository;
import wawer.kamil.universitymanager.service.impl.StudentServiceImpl;
import wawer.kamil.universitymanager.utils.mapper.ModelMapperHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
    StudentResponse studentResponse;

    @Mock
    StudentRequest studentRequest;

    @InjectMocks
    StudentServiceImpl studentService;

    private static final String STUDENT_ID = "id";
    private static final Integer SIZE_OF_PAGE = 1;
    private static final Integer PAGE_NUMBER = 1;
    private static final String GENERATED_VALUE = "Generated";

    @Test
    public void should_return_list_of_response_students_when_call_getAllStudents_method() {
        when(studentRepository.findAll()).thenReturn(studentList);
        when(modelMapperHelper.mapListOfStudentsEntitiesToListOfStudentsResponse(studentList)).thenReturn(studentResponseList);
        assertEquals(studentResponseList, studentService.getAllStudents());
    }


}
