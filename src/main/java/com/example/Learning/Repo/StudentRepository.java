package com.example.Learning.Repo;

import com.example.Learning.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.DataClassRowMapper;

import java.lang.reflect.Constructor;

public interface StudentRepository extends JpaRepository<Student,Long> {
    //jdbcTemplate.query(
    //    "SELECT id, name FROM users",
//        DataClassRowMapper.getInstance(User.class)
}
