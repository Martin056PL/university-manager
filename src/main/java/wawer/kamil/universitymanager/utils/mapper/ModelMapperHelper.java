package wawer.kamil.universitymanager.utils.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import wawer.kamil.universitymanager.dto.request.StudentRequest;
import wawer.kamil.universitymanager.dto.response.StudentResponse;
import wawer.kamil.universitymanager.model.Student;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ModelMapperHelper {

    private final ModelMapper modelMapper;

    public List<StudentResponse> mapListOfStudentsEntitiesToListOfStudentsResponse(List<Student> studentList) {
        return studentList.stream().map(student -> modelMapper.map(student, StudentResponse.class)).collect(Collectors.toList());
    }

    public StudentResponse mapStudentEntityToStudentResponse(Student student) {
        return modelMapper.map(student, StudentResponse.class);
    }

    public Student mapStudentRequestToStudentEntity(StudentRequest studentRequest) {
        return modelMapper.map(studentRequest, Student.class);
    }

}
