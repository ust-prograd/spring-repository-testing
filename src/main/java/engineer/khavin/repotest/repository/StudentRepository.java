package engineer.khavin.repotest.repository;

import engineer.khavin.repotest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(
            "SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Student s WHERE s.email = ?1"
    )
    public Boolean checkIfEmailExists(String email);
}
