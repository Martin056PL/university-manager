package wawer.kamil.universitymanager.utils.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import wawer.kamil.universitymanager.dto.request.StudentRequest;
import wawer.kamil.universitymanager.dto.response.StudentResponse;
import wawer.kamil.universitymanager.model.Student;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ModelMapperHelperTest {

    @Mock
    ModelMapper modelMapper;

    @Mock
    Student student;

    @Mock
    StudentResponse studentResponse;

    @Mock
    StudentRequest studentRequest;

    @InjectMocks
    ModelMapperHelper modelMapperHelper;


    @Test
    public void should_map_from_list_of_students_entities_to_list_of_students_response_when_call_mapListOfStudentsEntitiesToListOfStudentsResponse() {
        List<Student> studentList = List.of(student, student, student);
        List<StudentResponse> studentResponseList = List.of(studentResponse, studentResponse, studentResponse);
        when(modelMapper.map(student, StudentResponse.class)).thenReturn(studentResponse);
        assertEquals(studentResponseList, modelMapperHelper.mapListOfStudentsEntitiesToListOfStudentsResponse(studentList));
        assertEquals(studentResponseList.size(), studentList.size());
    }

    @Test
    public void should_map_from_student_entity_to_student_response_when_call_mapStudentEntityToStudentResponse() {
        when(modelMapper.map(student, StudentResponse.class)).thenReturn(studentResponse);
        assertEquals(studentResponse, modelMapperHelper.mapStudentEntityToStudentResponse(student));
    }

    @Test
    public void should_map_from_student_request_to_student_entity_when_call_mapStudentRequestToStudentEntity() {
        when(modelMapper.map(studentRequest, Student.class)).thenReturn(student);
        assertEquals(student, modelMapperHelper.mapStudentRequestToStudentEntity(studentRequest));
    }


}
