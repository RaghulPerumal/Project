package com.example.Learning.Repo;

import com.example.Learning.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    //jdbcTemplate.query(
    //    "SELECT id, name FROM users",
    //    DataClassRowMapper.getInstance(User.class)
}
