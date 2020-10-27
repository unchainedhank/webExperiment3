package edu.web3.demo.controller;

import edu.web3.demo.Domain.Student;
import edu.web3.demo.Domain.StudentResponse;
import edu.web3.demo.service.StudentService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080/#/",maxAge = 1000)
public class StudentController implements Serializable {
    @Resource
    private StudentService studentService;

    @GetMapping("/all-students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @RequestMapping(value = "/login/{email}/{password}", method = RequestMethod.GET)
    public StudentResponse validate(@PathVariable String email, @PathVariable String password) {
        var s = new Student();
        var response = new StudentResponse();

        try {
            s = studentService.findByEmail(email);
        } catch (EmptyResultDataAccessException e) {
            response.setCode("email_error");
            return response;
        }

        var passWd = s.getPassword();
        if (!passWd.equals(password))
            response.setCode("passwd_error");
        else {
            response.setCode("success");
        }
        return response;
    }

    @RequestMapping(value = "/delete-student/{email}", method = RequestMethod.POST)
    public void deleteStudent(@PathVariable String email) {
        try {
            studentService.deleteByEmail(email);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/update-student",method = RequestMethod.PUT)
    public void updateStudent(@RequestParam("id") String id,@RequestParam("email") String email,@RequestParam("password") String password) {
        var iid = Integer.parseInt(id);
        studentService.updatePasswordAndEmailById(iid,email,password);
    }

    @PostMapping(value = "/insert-student")
    public StudentResponse saveNewStudent(@RequestBody Student student) {
        String password = student.getPassword();
        String email = student.getEmail();
        String major = student.getMajor();
        String name = student.getName();

        StudentResponse studentResponse = new StudentResponse();
        if (studentService.save(name, password, major, email)) {
            studentResponse.setCode("succeed");
        } else {
            studentResponse.setCode("failed");
        }
        return studentResponse;
    }



}
