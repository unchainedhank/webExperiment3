package edu.web3.demo.controller;

import edu.web3.demo.Domain.Student;
import edu.web3.demo.Domain.StudentResponse;
import edu.web3.demo.service.StudentService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080/#/",maxAge = 1000)
//@CrossOrigin("http://localhost:8080")
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("/all-students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @RequestMapping(value = "/login/{name}/{password}", method = RequestMethod.GET)
    public StudentResponse validate(@PathVariable String name, @PathVariable String password) {
        var s = new Student();
        var response = new StudentResponse();
        try {
            s = studentService.findByName(name);

        } catch (EmptyResultDataAccessException e) {
            response.setCode("user_error");
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


}
