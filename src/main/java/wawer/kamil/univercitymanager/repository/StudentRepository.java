package wawer.kamil.univercitymanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import wawer.kamil.univercitymanager.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
