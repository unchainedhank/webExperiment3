package edu.web3.demo.dao;

import edu.web3.demo.Domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class StudentDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public Student findById(int id) {
        //queryForObject用于查询单条记录返回结果
        return jdbcTemplate.queryForObject("SELECT * FROM student.student_table WHERE id=?",
                new Object[]{id},new BeanPropertyRowMapper<>(Student.class));
    }

    public Student findByName(String name) {
        //queryForObject用于查询单条记录返回结果
        return jdbcTemplate.queryForObject("SELECT * FROM student.student_table WHERE name=?",
                new Object[]{name},new BeanPropertyRowMapper<>(Student.class));
    }

    public Student findByEmail(String email) {
        //queryForObject用于查询单条记录返回结果
        return jdbcTemplate.queryForObject("SELECT * FROM student.student_table WHERE email=?",
                new Object[]{email},new BeanPropertyRowMapper<>(Student.class));
    }

    public void deleteByEmail(String email) {
        jdbcTemplate.update("delete from student.student_table where email=?",email);
    }


    //查找所有学生
    public List<Student> findAll() {
        return jdbcTemplate.query("select * from student.student_table", new BeanPropertyRowMapper<>(Student.class));
    }



}
