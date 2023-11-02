package com.pblgllgs.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(){
        return new ResponseEntity<>(studentService.findAllStudents(),HttpStatus.OK);
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findStudentsBySchoolId(@PathVariable("school-id") Integer schoolId){
        return new ResponseEntity<>(studentService.findStudentsBySchoolId(schoolId),HttpStatus.OK);
    }

}
