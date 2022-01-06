package engineer.khavin.repotest.repository;

import engineer.khavin.repotest.entity.Student;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repo;

    @Nested
    class ChecksIfEmailExistsOrNot {
        @BeforeEach
        public void setUp() {
            Student khavin = new Student("Khavin", "khavin@gmail.com", 25);
            repo.save(khavin);
        }

        @AfterEach
        public void tearDown() {
            repo.deleteAll();
        }


        @Test
        public void returnsTrueIfEmailExists() {
            Boolean actual = repo.checkIfEmailExists("khavin@gmail.com");
            Assertions.assertTrue(actual);
        }


        @Test
        public void returnsFalseIfEmailDoesNotExists() {
            Boolean actual = repo.checkIfEmailExists("athira@gmail.com");
            // Assertions.assertFalse(actual);
            Assertions.assertEquals(false, actual);
        }
    }

}