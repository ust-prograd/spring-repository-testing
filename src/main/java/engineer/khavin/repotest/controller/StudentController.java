package engineer.khavin.repotest.controller;

import engineer.khavin.repotest.entity.Student;
import engineer.khavin.repotest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> list() {
        return service.getAllStudents();
    }

    @GetMapping("/students/new")
    public Student create(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Integer age = Integer.parseInt(request.getParameter("age"));

        Student student = new Student(name, email, age);
        return service.createStudent(student);
    }

    @GetMapping("/students/check/email/{email}") // localhost:3000/students/check/email/khavin@gmail.com
    public Boolean checkEmail(@PathVariable String email) {
        return service.checkIfEmailExists(email);
    }

}
