package com.example.Learning.Controller;

import com.example.Learning.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")         //http://localhost:8080/student/about
public class StudentController {

    @GetMapping("/about")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> about() {
        return ResponseEntity.ok("About");
//        return new ResponseEntity<>("About", HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.OK).body("About");
    }

//    @PostMapping("/")
//    public ResponseEntity<Student>
}
