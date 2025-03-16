package com.avi.rest.controller;

import com.avi.rest.entity.Student;
import com.avi.rest.exception.StudentExceptionResponse;
import com.avi.rest.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    List<Student> theStudent;
    @PostConstruct
    public List<Student> loadStudents(){
        theStudent = new ArrayList<>();

        theStudent.add(new Student("Avinash","Kumar"));
        theStudent.add(new Student("Dilip", "Sharma"));
        theStudent.add(new Student("Jayant","Chaube"));

        return theStudent;
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return theStudent;
    }
    @GetMapping("/students/{id}")
    public Student getStudentsById(@PathVariable int id){

        if (id >= theStudent.size() || id < 0){
            throw new StudentNotFoundException("Student not found with id: "+ id);
        }
        return theStudent.get(id);
    }

    @ExceptionHandler
    public ResponseEntity<StudentExceptionResponse> handleExc(StudentNotFoundException exc){
        StudentExceptionResponse error = new StudentExceptionResponse();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
