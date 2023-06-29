package com.springrest.demo.rest;

import com.springrest.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents;

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student(1,"Philip","Bukki"));
        theStudents.add(new Student(2,"Jack","Ma"));
        theStudents.add(new Student(3,"Mark","Zuc"));

    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;

    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Not found student with id- "+ studentId);
        }

        return theStudents.get(studentId);

    }


}
