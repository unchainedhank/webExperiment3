package edu.web3.demo.service;

import edu.web3.demo.Domain.Student;
import edu.web3.demo.dao.StudentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    private StudentDao studentDao;

    public Student findByName(String name) {
        return studentDao.findByName(name);
    }

    public Student findById(int id) {
        return studentDao.findById(id);
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findByEmail(String email) {
        return studentDao.findByEmail(email);
    }

    public void deleteByEmail(String email) {
        studentDao.deleteByEmail(email);
    }

    public void updatePasswordAndEmailById(int id, String password, String email) {
        studentDao.updatePasswordAndEmailById(id, password, email);
    }

}
