package com.example.Learning.Controller;

import com.example.Learning.DTO.StudentDTO;
import com.example.Learning.Model.Major;
import com.example.Learning.Model.Student;
import com.example.Learning.Repo.MajorRepository;
import com.example.Learning.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")         //http://localhost:8081/student/about
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MajorRepository majorRepository;

    @GetMapping(path = "/about")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> about() {
//        return ResponseEntity.ok("About");
        return new ResponseEntity<>("About", HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.OK).body("About");
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentDTO dto) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Student student = optionalStudent.get();

        if (dto.getName() != null) student.setName(dto.getName());
        if (dto.getEMail() != null) student.setEMail(dto.getEMail());
        if (dto.getDateOfBirth() != null) student.setDateOfBirth(dto.getDateOfBirth());
        if (dto.getCgpa() != null) student.setCgpa(dto.getCgpa());

        if (dto.getMajorId() != null) {
            Optional<Major> majorOptional = majorRepository.findById(dto.getMajorId());
            if (majorOptional.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            student.setMajor(majorOptional.get());
        }
        Student updated = studentRepository.save(student);
        return ResponseEntity.ok(updated);
    }
}
