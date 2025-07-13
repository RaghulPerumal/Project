package com.example.Learning.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/student")     //http://localhost:8080/about
public class StudentController {

    @GetMapping("/about")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> about() {
        return ResponseEntity.ok("About");
//        return new ResponseEntity<>("About", HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.OK).body("About");
    }

}
