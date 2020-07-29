package wawer.kamil.universitymanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import wawer.kamil.universitymanager.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
